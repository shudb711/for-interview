package all.javalearn.concurrent.Executor;

import all.javalearn.concurrent.atomic.AtomicTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task(i));
        }

        executorService.shutdown();


    }

    static class Task implements Callable<Integer>
    {
        int n;
        public Task(int n) {
            this.n = n;
        }

        public Integer call() throws Exception {
            System.out.println("当前线程是：" + Thread.currentThread().getName() + ",当前n值是：" + n++);
            return null;
        }
    }
}
