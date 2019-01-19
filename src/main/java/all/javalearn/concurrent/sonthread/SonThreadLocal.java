package all.javalearn.concurrent.sonthread;

/**
 * @Function:
 * @Author:shudb
 * @Date:2019/1/12 19:46
 **/
public class SonThreadLocal
{
    public static void main(String[] args) {
        ThreadLocalProvider.set("1111");
        System.out.println(ThreadLocalProvider.get());


        ThreadLocalProvider.set("2222");
        System.out.println(ThreadLocalProvider.get());

//        Thread.currentThread().setDaemon(true);
        Thread.currentThread().setPriority(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(ThreadLocalProvider.get());
                    System.out.println(Thread.currentThread().isDaemon());
                    System.out.println(Thread.currentThread().getPriority());
                }
            }).start();
        }


    }


}
