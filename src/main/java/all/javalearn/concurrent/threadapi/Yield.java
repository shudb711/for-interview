package all.javalearn.concurrent.threadapi;

import java.util.concurrent.TimeUnit;

/**
 * @Function:
 * @Author:shudb
 * @Date:2019/1/19 11:25
 **/
public class Yield
{
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new YieldThread(i), "thread" + i).start();
        }
    }

    static class YieldThread implements Runnable
    {
        private int i;
        public YieldThread(int i) {
            this.i = i;
        }

        public void run() {
            if (i % 2 == 0)
            {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "执行完了，此线程是" + (i % 2 == 0?"偶数":"奇数") + "线程");
        }
    }
}
