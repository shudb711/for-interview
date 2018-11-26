package all.javalearn.datastructure.linkedlist.doublepoint;

public class QueueLinkedList {
    private DoublePointLinkedList dpl;

    public QueueLinkedList(DoublePointLinkedList dpl) {
        this.dpl = dpl;
    }

    public void insert(Object data)
    {
        dpl.addHead(data);
    }

    public void delete()
    {
        dpl.deleteHead();
    }

    public boolean isEmpty()
    {
        return dpl.getSize() == 0;
    }
}
