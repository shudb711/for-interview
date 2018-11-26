package all.javalearn.concurrent.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/9/19 16:02
 **/
public class ThreadTest implements Runnable
{
    /**
     * 线程不安全示例
     * CountDownLatch类的作用是让所有的线程执行完成之后，执行主线程的代码
     * 注意与CyclicBarrier的异同点，
     */

    List list;
    CountDownLatch countDownLatch;

    public ThreadTest(List list, CountDownLatch countDownLatch) {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        list.add(new Object());
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        List list= new ArrayList();
//        List list= new Vector();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(new ThreadTest(list, countDownLatch)).start();
        }

        countDownLatch.await();
        System.out.println(list.size());
    }
}
