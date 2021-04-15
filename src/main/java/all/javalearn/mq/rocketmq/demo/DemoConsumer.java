package all.javalearn.mq.rocketmq.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Created on 2021/1/28 14:52
 *
 * @author shudebao@limikeji.com
 */
public class DemoConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_consumer", true);

        consumer.setNamesrvAddr("10.200.59.111:9876");
        consumer.subscribe("first_topic_test", "TagA");

//        consumer.setConsumeThreadMax();
//        consumer.setConsumeThreadMin();

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            //并发的
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                msgs.forEach(p -> {
                    System.out.println(p.toString());
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

//        consumer.registerMessageListener(new MessageListenerOrderly(){
//            //顺序的
//            @Override
//            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
//                return null;
//            }
//        });
        consumer.start();
    }
}
