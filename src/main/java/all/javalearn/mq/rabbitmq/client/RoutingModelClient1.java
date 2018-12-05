package all.javalearn.mq.rabbitmq.client;

import all.javalearn.mq.rabbitmq.connectionfactory.GenerateConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式
 */

public class RoutingModelClient1
{
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = GenerateConnection.getConnectionFactory();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("x-dead-letter-exchange", "some.exchange.name");
        channel.queueDeclare("accept_queue3", true, false, false, params);
        channel.queueBind("accept_queue3", EXCHANGE_NAME, "info");

//        channel.queueBind(queueName, EXCHANGE_NAME, "error");
//        channel.queueBind(queueName, EXCHANGE_NAME, "warn");

        channel.exchangeDeclare("some.exchange.name", "direct");
        channel.queueDeclare("dead_queue",false,false,false,null);
        channel.queueBind("dead_queue", "some.exchange.name", "info");


        channel.basicConsume("accept_queue3", false, new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                String message = new String(body, "UTF-8");
//                System.out.println("dead_queue" + ":[x] Received '" + message + "'" + envelope.getRoutingKey() + envelope.getDeliveryTag() + envelope.getExchange());
                channel.basicReject(envelope.getDeliveryTag(),false);
            }
        });
    }
}

