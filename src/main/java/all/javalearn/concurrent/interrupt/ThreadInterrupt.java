package all.javalearn.concurrent.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Function:
 * @Author:shudb
 * @Date:2019/1/12 20:11
 **/
public class ThreadInterrupt
{
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() +"中断状态" + Thread.currentThread().isInterrupted());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() +"中断状态" + Thread.currentThread().isInterrupted());
            }
        });
        thread1.start();
        thread1.interrupt();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    System.out.println(333333);
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread2.start();
        thread2.interrupt();
    }
}
