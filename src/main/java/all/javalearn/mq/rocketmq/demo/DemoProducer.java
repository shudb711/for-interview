package all.javalearn.mq.rocketmq.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2021/1/28 14:45
 *
 * @author shudebao@limikeji.com
 */
public class DemoProducer {
    public static void main(String[] args) throws Exception {
        //todo producer group
        DefaultMQProducer producer = new DefaultMQProducer("test_producer", true);
        producer.setNamesrvAddr("10.200.59.111:9876");
        producer.start();

        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        Message message = new Message("first_topic_test", "TagA", String.valueOf(atomicInteger.incrementAndGet()), "hahhah".getBytes());
                        try {
                            SendResult send = producer.send(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        while (true) {
            Thread.sleep(1000);
        }
    }


}
