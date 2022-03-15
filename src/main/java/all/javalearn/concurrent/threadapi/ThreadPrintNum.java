package all.javalearn.concurrent.threadapi;

/**
 * author:shudb
 * date:2022/3/15
 * email:shudebao@aliyun.com
 * description:三个线程合作打印出1-10
 */

public class ThreadPrintNum {

    static volatile int n = 0;
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (o) {
                        if (++n > 10) {
                            break;
                        }
                        System.out.println(n);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (o) {
                        if (++n > 10) {
                            break;
                        }
                        System.out.println(n);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (o) {
                        if (++n > 10) {
                            break;
                        }
                        System.out.println(n);
                    }
                }
            }
        }).start();
    }
}
