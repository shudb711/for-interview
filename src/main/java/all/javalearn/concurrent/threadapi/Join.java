package all.javalearn.concurrent.threadapi;

import java.util.concurrent.TimeUnit;

/**
 * @Function:
 * @Author:shudb
 * @Date:2019/1/19 11:08
 **/
public class Join
{
    public static void main(String[] args) throws InterruptedException {
        //执行结果：子线程执行前-->(5s后)子线程执行后-->主线程执行完了
        System.out.println("子线程执行前");

        Thread thread = new Thread(new JoinThread());
        thread.start();
        thread.join();

        System.out.println("主线程执行完了");
    }

    static class JoinThread implements Runnable
    {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("子线程执行后");
            } catch (InterruptedException e) {

            }
        }
    }
}
