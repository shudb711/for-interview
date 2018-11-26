package all.javalearn.mq.rabbitmq.server;

import all.javalearn.mq.rabbitmq.connectionfactory.GenerateConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * topic模式(direct)
 */
public class TopicModelServer
{
    private static final String EXCHANGE_NAME = "topic_logss";

    public static void main(String[] args)
    {
        for (int n = 0; n < 100; n++) {
            new Thread(new Runnable() {
                public void run() {
                    Connection connection = null;
                    Channel channel = null;
                    try
                    {
                        connection = GenerateConnection.getConnectionFactory();
                        channel = connection.createChannel();

                        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
                        for (int i = 0; i < 20; i++) {
                            String message = "Hello World";
                            for (int j = 0; j < i; j++) {
                                message += ".";
                            }

                            message = "线程:" + Thread.currentThread().getName() + ",第" + i + "条消息:" + message;
                            channel.basicPublish(EXCHANGE_NAME, "topic" + (new Random().nextInt(3) + 1) + ".log.app", null, message.getBytes());
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        if (channel != null)
                        {
                            try {
                                channel.close();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                        if (connection != null)
                        {
                            try {
                                connection.close();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }

    }
}
