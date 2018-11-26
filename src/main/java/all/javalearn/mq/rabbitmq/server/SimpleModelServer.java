package all.javalearn.mq.rabbitmq.server;

import all.javalearn.mq.rabbitmq.connectionfactory.GenerateConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete,Map<String, Object> arguments),这几个参数的含义
 */

/**
 * 简单模式
 */
public class SimpleModelServer
{
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        Connection connection = null;
        Channel channel = null;
        try
        {
            connection = GenerateConnection.getConnectionFactory();
            System.out.println(connection);
            channel = connection.createChannel();
            //？？排他性
            channel.queueDeclare(QUEUE_NAME,  false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        catch (Exception e) {
            if (channel != null)
            {
                channel.close();
            }
            if (connection != null)
            {
                connection.close();
            }
        }
    }
}
