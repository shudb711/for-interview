package all.javalearn.concurrent.producerconsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @Author:shudb
 * @Date:2018/8/14 11:48
 **/
public class ArrayBlockingQueueConsumer implements Callable<String>
{
    /**
     * 消费
     */
    public void consume() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = ArrayBlockingQueueOffer.getArrayBlockingQueue();
        for (int i = 0;i < 3;i++)
        {
            String take = arrayBlockingQueue.take();
            System.out.println("消费了：" + take);
            Thread.sleep(3000);
        }
    }

    public String call() throws Exception {
        consume();
        return "consumer";
    }
}
