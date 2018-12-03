package all.javalearn.concurrent.threadsafe;

import java.util.concurrent.CountDownLatch;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/12/3 17:16
 **/
public class VolatileDemo
{
//    private int i = 0;
    private volatile int i = 0;
    private void addOne()
    {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileDemo volatileDemo = new VolatileDemo();
        CountDownLatch countDownLatch = new CountDownLatch(10000);

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    volatileDemo.addOne();
                    System.out.println("线程" + Thread.currentThread().getName() + "执行完毕!");
                    countDownLatch.countDown();;
                }
            }).start();
        }

        countDownLatch.await();

        //无论有没有volatile关键字修饰i，打印出来9998，9999,10000等
        System.out.println(volatileDemo.i);

    }
}
