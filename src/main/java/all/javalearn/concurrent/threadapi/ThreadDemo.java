package all.javalearn.concurrent.threadapi;/*
    created by shudb at 2020/2/27 19:44
*/

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        int i =1;
        System.out.println(~i);
        System.out.println(1&(-1));

        AtomicInteger atomicInteger = new AtomicInteger((-1 << 29) | 0);
        int expect = atomicInteger.get();
        atomicInteger.compareAndSet(expect, expect + 1);
        System.out.println(atomicInteger.get());
    }
}
