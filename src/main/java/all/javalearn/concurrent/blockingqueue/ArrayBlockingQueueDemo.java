package all.javalearn.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ArrayBlockingQueueDemo {

    private static ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true)
                {
                    arrayBlockingQueue.offer("aaaa");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true)
                {
                    int size = arrayBlockingQueue.size();
                    if (size > 0)
                    {
                        String poll = arrayBlockingQueue.poll();
                        System.out.println(Thread.currentThread().getName() + ":消费前有" + size + "个");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true)
                {
                    int size = arrayBlockingQueue.size();
                    if (size > 0)
                    {
                        String poll = arrayBlockingQueue.poll();
                        System.out.println(Thread.currentThread().getName() + ":消费前有" + size + "个");
                    }
                }
            }
        }).start();

        new Thread()
        {
            public void run() {
                while (true)
                {
                    int size = arrayBlockingQueue.size();
                    if (size > 0)
                    {
                        String poll = arrayBlockingQueue.poll();
                        System.out.println(Thread.currentThread().getName() + ":消费前有you" + size + "个");
                    }
                }
            }
        }.start();

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            public String call() throws Exception {
                return "hello concurrent";
            }
        });
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        new Thread()
        {
            public void run() {
                Integer.parseInt("wwww");
            }
        }.start();
    }
}
