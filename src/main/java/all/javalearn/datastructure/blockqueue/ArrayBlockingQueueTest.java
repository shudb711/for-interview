package all.javalearn.datastructure.blockqueue;

import java.util.concurrent.FutureTask;

/**
 * @Author:shudb
 * @Date:2018/8/14 14:25
 **/
public class ArrayBlockingQueueTest
{
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new ArrayBlockingQueueProuducer());
        new Thread(futureTask).start();

        FutureTask<String> futureTask1 = new FutureTask<>(new ArrayBlockingQueueConsumer());
        new Thread(futureTask1).start();

    }
}
