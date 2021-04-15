package all.javalearn.concurrent.blockingqueue;

import java.util.concurrent.*;

/**
 * Created on 2020/6/16 9:26
 * Author shudebao@limikeji.com
 */
public class ArrayBlockQueue {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10000);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10000; i++) {
            arrayBlockingQueue.offer(i);
        }

        for (int i = 0; i < 10; i++) {
            ArrayBlockQueue.Task task = new ArrayBlockQueue().new Task(arrayBlockingQueue, countDownLatch);
            task.start();
        }
        countDownLatch.await();
        System.out.println("所有线程执行完毕");
    }

    class Task extends Thread {

        private ArrayBlockingQueue<Integer> arrayBlockingQueue;
        private CountDownLatch countDownLatch;

        public Task(ArrayBlockingQueue<Integer> arrayBlockingQueue,CountDownLatch countDownLatch) {
            this.arrayBlockingQueue = arrayBlockingQueue;
            this.countDownLatch = countDownLatch;
        }


        @Override
        public void run() {
            Integer a;
            while ((a = arrayBlockingQueue.poll()) != null) {
                System.out.println(Thread.currentThread().getName() + ":" + a);
            }
            countDownLatch.countDown();
        }
    }
}
