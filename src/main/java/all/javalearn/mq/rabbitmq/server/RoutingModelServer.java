package all.javalearn.mq.rabbitmq.server;

import all.javalearn.mq.rabbitmq.connectionfactory.GenerateConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式(direct)
 */
public class RoutingModelServer
{
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        Connection connection = null;
        Channel channel = null;
        try
        {
            connection = GenerateConnection.getConnectionFactory();
            channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            for (int i = 0; i < 20; i++) {
                String message = "Hello World";
                for (int j = 0; j < i; j++) {
                    message += ".";
                }
                channel.basicPublish(EXCHANGE_NAME, "error", null, message.getBytes());
            }
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
