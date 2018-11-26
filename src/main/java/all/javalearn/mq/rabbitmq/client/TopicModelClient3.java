package all.javalearn.mq.rabbitmq.client;

import all.javalearn.mq.rabbitmq.connectionfactory.GenerateConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * topic模式：#代表零个，一个或多个单词，*代表只能一个单词
 */

public class TopicModelClient3
{
    private static final String EXCHANGE_NAME = "topic_logss";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = GenerateConnection.getConnectionFactory();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queueName = channel.queueDeclare().getQueue();
//        channel.queueBind(queueName, EXCHANGE_NAME, "topic.*");
//        channel.queueBind(queueName, EXCHANGE_NAME, "topic.log.*");
//        channel.queueBind(queueName, EXCHANGE_NAME, "topic.log.app.*");

        channel.queueBind(queueName, EXCHANGE_NAME, "topic3.#");
//        channel.queueBind(queueName, EXCHANGE_NAME, "topic.log.#");
//        channel.queueBind(queueName, EXCHANGE_NAME, "topic.log.app.#");





//        channel.queueBind(queueName, EXCHANGE_NAME, "topic.log.app");


        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(queueName + ":[x] Received '" + message + "'" + ":" + consumerTag + ":" + envelope.getRoutingKey() + ":" + envelope.getDeliveryTag() + ":" + envelope.getExchange());
                channel.basicAck(envelope.getDeliveryTag(),true);
            }
        };
        channel.basicConsume(queueName, false, "1111", defaultConsumer);
    }
}

