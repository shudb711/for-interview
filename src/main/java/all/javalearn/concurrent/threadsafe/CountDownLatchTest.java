package all.javalearn.concurrent.threadsafe;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/9/19 16:51
 **/
public class CountDownLatchTest
{
    private static CountDownLatch countDownLatch = new CountDownLatch(7);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            int index = i + 1;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("收集到第" + index + "颗龙珠");

                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();

        System.out.println("收集到七颗龙珠，开始召唤神龙");
    }
}
