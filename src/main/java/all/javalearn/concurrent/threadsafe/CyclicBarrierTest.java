package all.javalearn.concurrent.threadsafe;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/9/19 16:58
 **/
public class CyclicBarrierTest
{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            public void run() {
                System.out.println("七个法师召唤完毕");
                summonDragon();
            }
        });

        for (int i = 0; i < 7; i++) {
            int index = i + 1;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("召集到第" + index + "个法师");
                    try {
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static void summonDragon()
    {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            public void run() {
                System.out.println("集齐七颗龙珠，开始召唤神龙");
            }
        });

        for (int i = 0; i < 7; i++) {
            int index = i + 1;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("收集到第" + index + "个龙珠");
                    try {
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
