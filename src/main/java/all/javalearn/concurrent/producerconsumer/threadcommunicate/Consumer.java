package all.javalearn.concurrent.producerconsumer.threadcommunicate;

import all.javalearn.datastructure.linkedlist.singlepoint.SingleLinkedList;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/8/14 14:49
 **/
public class Consumer implements Runnable
{
    public void run() {
        try {
            while (true)
            {
                consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume() throws InterruptedException {
        SingleLinkedList<Peach> singleLinkedList = Basket.getSingleLinkedList();
        Lock lock = Lock.lock();
        synchronized (lock)
        {
            if (singleLinkedList.getSize() <= 0)
            {
                lock.wait();
            }
            Peach peach = singleLinkedList.deleteHead();
            System.out.println(Thread.currentThread().getName() + "消费了编号为：" + peach.getPid() + "的桃");
            lock.notify();
        }
    }
}
