package all.javalearn.concurrent.producerconsumer.threadcommunicate;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/8 13:46
 **/
public class Lock
{
    private static volatile Lock lock;
    public static Lock lock()
    {
        if (lock == null)
        {
            synchronized (Lock.class)
            {
                if (lock == null)
                {
                    lock = new Lock();
                }
            }
        }
        return lock;
    }
}
