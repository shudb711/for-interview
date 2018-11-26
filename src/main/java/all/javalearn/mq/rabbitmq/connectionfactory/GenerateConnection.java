package all.javalearn.mq.rabbitmq.connectionfactory;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class GenerateConnection {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    static
    {
        connectionFactory.setHost("10.1.1.32");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
    }
    public static Connection getConnectionFactory()
    {
        try {
            return connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}