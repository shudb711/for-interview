package all.javalearn.concurrent.producerconsumer.threadcommunicate;

import all.javalearn.datastructure.linkedlist.singlepoint.SingleLinkedList;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/8/14 14:50
 **/
public class Basket
{
    private static volatile SingleLinkedList singleLinkedList = null;

    public static SingleLinkedList<Peach> getSingleLinkedList()
    {
        if (singleLinkedList == null)
        {
            synchronized (Basket.class)
            {
                if (singleLinkedList == null)
                {
                    singleLinkedList = new SingleLinkedList();
                }
            }
        }
        return singleLinkedList;
    }
}
