package all.javalearn.datastructure.stack.linkstack;

import all.javalearn.datastructure.linkedlist.singlepoint.SingleLinkedList;

public class SingleLinkedStack
{
    private SingleLinkedList singleLinkedList;
    public SingleLinkedStack (SingleLinkedList singleLinkedList)
    {
        this.singleLinkedList = singleLinkedList;
    }

    //压栈
    public void push(Object obj)
    {
        singleLinkedList.add(obj);
    }

    //弾栈
    public Object pop()
    {
        return singleLinkedList.deleteHead();
    }

    public boolean isEmpty()
    {
        return singleLinkedList.getSize() == 0;
    }
}
