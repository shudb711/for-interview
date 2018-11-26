package all.javalearn.datastructure.linkedlist.orderlink;

public class OrderLinkedList
{
    private int size;
    private Node head;

    public OrderLinkedList() {
        this.size = 0;
        this.head = null;
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

    /**
     * 添加元素
     */
    public void add(Integer i) {
        Node<Integer> node = new Node<>(i);
        Node<Integer> pre = null;
        Node<Integer> currentNode = head;
        while (currentNode != null && i > currentNode.data) {
            pre = currentNode;
            currentNode = currentNode.next;
        }

        if (pre == null) {
            head = node;
            head.next = currentNode;
        }
        else
        {
            pre.next = node;
            node.next = currentNode;
        }
        size++;
    }
    /**
     * 删除头元素
     */
    public Object deleteHead()
    {
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }

    class Node<Integer>
    {
        private Integer data;
        private Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }
}
