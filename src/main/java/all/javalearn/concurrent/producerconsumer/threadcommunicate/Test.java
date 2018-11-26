package all.javalearn.concurrent.producerconsumer.threadcommunicate;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/8/14 15:09
 **/
public class Test
{
    public static void main(String[] args) {
        new Thread(new Producer()).start();

        new Thread(new Consumer()).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("hahahaha");
            }
        }).start();
    }
}
