package all.javalearn.datastructure.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author:shudb
 * @Date:2018/8/14 11:48
 **/
public class ArrayBlockingQueueOffer
{
    private static volatile ArrayBlockingQueue<String> arrayBlockingQueue = null;
    public static ArrayBlockingQueue getArrayBlockingQueue()
    {
        if (arrayBlockingQueue == null)
        {
            synchronized (ArrayBlockingQueueOffer.class)
            {
                if (arrayBlockingQueue == null)
                {
                    arrayBlockingQueue = new ArrayBlockingQueue<>(2);
                }
            }
        }
        return arrayBlockingQueue;
    }
}