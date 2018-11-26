package all.javalearn.concurrent.producerconsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @Author:shudb
 * @Date:2018/8/14 11:48
 **/
public class ArrayBlockingQueueProuducer implements Callable<String>
{
    /**
     * 生产
     */
    public void produce() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = ArrayBlockingQueueOffer.getArrayBlockingQueue();
        for (int i = 0; i < 3; i++) {
            arrayBlockingQueue.put(i + "");
            System.out.println("生产了：" + i);
            System.out.println("还剩余：" + arrayBlockingQueue.size());
            Thread.sleep(100);
        }
    }

    public String call() throws Exception {
        produce();
        return "produce";
    }
}
