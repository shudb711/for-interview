package all.javalearn.concurrent.producerconsumer.blockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author:shudb
 * @Date:2018/8/14 14:25
 **/
public class ArrayBlockingQueueTest
{
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        /**
         * Callable是任务，Future和FutureTask可获取计算的结果值
         * 1、Future< submit = executorService.submit（Callable c）
         *
         * 2、executorService.submit（Runnable r）
         *      FutureTask是Runnale的实现类，所以可以传入sunbmit(Runnable r)
         *
         */

        ////////////////////////=======1开始(Future和Callable)=======////////////////////////////////////////
//        Future<?> submit = executorService.submit(new ArrayBlockingQueueProuducer());
//        Future<?> submit1 = executorService.submit(new ArrayBlockingQueueConsumer());
//
//        executorService.shutdown();
//
//        System.out.println(submit.get() + "===========" + submit1.get());
        ///////////////////////////=======1结束=======///////////////////////////////////////////

        ///////////////////////////=======2开始(FutureTask和Callable)=======///////////////////////////////////////////
        FutureTask<String> futureTask = new FutureTask<>(new ArrayBlockingQueueProuducer());
        FutureTask<String> futureTask1 = new FutureTask<>(new ArrayBlockingQueueConsumer());

        executorService.submit(futureTask);
        executorService.submit(futureTask1);

        executorService.shutdown();

        System.out.println(futureTask.get() + "===========" + futureTask1.get());
        ///////////////////////////=======2结束=======///////////////////////////////////////////
    }
}
