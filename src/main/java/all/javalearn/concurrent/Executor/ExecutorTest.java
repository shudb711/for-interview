package all.javalearn.concurrent.Executor;

import all.javalearn.concurrent.atomic.AtomicTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorTest {

    private static int ctlOf(int rs, int wc) { return rs | wc; }
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        Future<String> submit = executorService.submit(new Task());
//
//
//        executorService.shutdown();

        //00000000 00000000 00000000 00000001
        //11111111 11111111 11111111 11111110
        //11111111 11111111 11111111 11111111
        //
        int i = -1 << 29;
        System.out.println(i | 0);

        AtomicInteger ctl = new AtomicInteger(ctlOf(i, 0));
        System.out.println(ctl);


    }

    static class Task implements Callable<String>
    {
        public String call() throws Exception {
            System.out.println("当前线程是：" + Thread.currentThread().getName());
            return null;
        }
    }
}
