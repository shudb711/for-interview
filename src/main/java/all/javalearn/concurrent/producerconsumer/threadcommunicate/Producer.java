package all.javalearn.concurrent.producerconsumer.threadcommunicate;

import all.javalearn.datastructure.linkedlist.singlepoint.SingleLinkedList;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/8/14 14:49
 **/
public class Producer implements Runnable
{
    public void run() {
        try {
            int i = 0;
            while (true)
            {
                i++;
                produce(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void produce(int i) throws InterruptedException {
        SingleLinkedList<Peach> singleLinkedList = Basket.getSingleLinkedList();
        Lock lock = Lock.lock();
        synchronized (lock)
        {
            if (singleLinkedList.getSize() >= 2)
            {
                lock.wait();
            }
            Peach peach = new Peach(i);
            singleLinkedList.add(peach);
            System.out.println(Thread.currentThread().getName() + "生产了编号为：" + peach.getPid() + "的桃");
            lock.notify();
            Thread.sleep(3000);
        }
    }
}
