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
        for (int i = 0; i < 10000; i++) {
            CountDownLatch countDownLatch = new CountDownLatch(2);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.addOne();
                    countDownLatch.countDown();;
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.addOne();
                    countDownLatch.countDown();;
                }
            }).start();

            countDownLatch.await();
        }

        //如果没有volatile关键字修饰i，打印出来19998，19999,20000等
        System.out.println(volatileDemo.i);

    }
}
