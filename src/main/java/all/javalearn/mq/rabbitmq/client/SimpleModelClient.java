package all.javalearn.mq.rabbitmq.client;

import all.javalearn.mq.rabbitmq.connectionfactory.GenerateConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单模式
 */
public class SimpleModelClient
{
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args)
    {
        Connection connection = null;
        Channel channel = null;
        try
        {
            connection = GenerateConnection.getConnectionFactory();
            System.out.println(connection);
            channel = connection.createChannel();

            //push模式
            channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel) {
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            });

            //pull模式
//            GetResponse getResponse = channel.basicGet(QUEUE_NAME, true);
//            System.out.println(new String(getResponse.getBody(), "UTF-8"));
        }
        catch (Exception e) {
            if (channel != null)
            {
                try {
                    channel.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (TimeoutException e1) {
                    e1.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
