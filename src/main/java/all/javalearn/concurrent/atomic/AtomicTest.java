package all.javalearn.concurrent.atomic;


import all.javalearn.concurrent.producerconsumer.threadcommunicate.Basket;
import all.javalearn.concurrent.producerconsumer.threadcommunicate.Peach;
import all.javalearn.datastructure.linkedlist.singlepoint.SingleLinkedList;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest
{
    static int i = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void increseNotAtomic()
    {
        for (int j = 0; j < 100; j++) {
            i++;
        }
    }

    public static void increseAtomic()
    {
        for (int j = 0; j < 100; j++) {
            atomicInteger.incrementAndGet();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2000);

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    increseNotAtomic();
                    try {
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    increseAtomic();
                    try {
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        countDownLatch.await();

        System.out.println("非原子操作，i=" + i);
        System.out.println("原子操作，atomicInteger=" + atomicInteger.get());
    }
}
