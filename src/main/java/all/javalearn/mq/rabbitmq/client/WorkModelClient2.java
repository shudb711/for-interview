package all.javalearn.mq.rabbitmq.client;

import all.javalearn.mq.rabbitmq.connectionfactory.GenerateConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * work模式
 */
public class WorkModelClient2
{
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = GenerateConnection.getConnectionFactory();
        Channel channel = connection.createChannel();

        channel.basicQos(1);
        channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

                for (char ch: message.toCharArray()) {
                    if (ch == '.') {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
