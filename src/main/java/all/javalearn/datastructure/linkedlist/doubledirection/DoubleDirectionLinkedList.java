package all.javalearn.datastructure.linkedlist.doubledirection;

public class DoubleDirectionLinkedList
{
    private int size;
    private Node head;
    private Node tail;

    public DoubleDirectionLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * 链表头添加元素
     */
    public void addHead(Object object)
    {
        Node<Object> newHead = new Node<>(object);
        if (size == 0)
        {
            head = newHead;
            tail = newHead;
        }
        else
        {
            newHead.next = head;
            head.pre = newHead;
            head = newHead;
        }
        size++;
    }

    /**
     * 链表尾添加元素
     */
    public void addTail(Object object)
    {
        Node<Object> newTail = new Node<>(object);
        if (size == 0)
        {
            head = newTail;
            tail = newTail;
        }
        else
        {
            tail.next = newTail;
            newTail.pre = tail;
            tail = newTail;
        }
        size++;
    }


    /**
     * 删除头元素
     */
    public boolean deleteHead()
    {
        if (size == 0)
            return false;

        if (head.next == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            head.pre = null;
        }
        size--;
        return true;
    }

    class Node<Object>
    {
        private Object data;
        private Node pre;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
