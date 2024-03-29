package all.javalearn.datastructure.linkedlist.singlepoint;

public class SingleLinkedList<K>
{
    private int size;
    private Node<K> head;

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    //反转链表，迭代
    public Node reverse1() {
        Node pre = null;
        Node next = null;

        Node node = head;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    //反转链表，递归 todo
    public Node reverse2(Node head) {
        if (head.next == null) return head;
        Node last = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
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
    public void add(K k)
    {
        Node<K> newHead = new Node<>(k);
        if (size == 0)
        {
            head = newHead;
        }
        else
        {
            newHead.next = head;
            head = newHead;
        }
        size++;
    }
    /**
     * 删除头元素
     */
    public K deleteHead()
    {
        K data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * 删除指定的元素
     */
    public boolean delete(K obj)
    {
        if (head == null)
            return false;

        Node currentNode = head;
        Node frontNode = null;
        int templeSize = size;
        while (templeSize > 0)
        {
            if (obj.equals(currentNode.data))
            {
                size--;
                if (currentNode == head)
                {
                    head = head.next;
                    return true;
                }
                else
                {
                    frontNode.next = currentNode.next;
                    return true;
                }
            }
            else
            {
                frontNode = currentNode;
                currentNode = currentNode.next;
                templeSize--;
            }
        }


        return false;
    }

    /**
     * 查找元素
     */
    public Node find(K obj)
    {
        if (head == null)
            return null;

        Node current = head;
        int tempSize =size;
        while (tempSize > 0)
        {
            if (obj.equals(current.data))
            {
                return current;
            }
            else
            {
                current = current.next;
                tempSize--;
            }
        }
        return null;
    }

    class Node<K>
    {
        private K data;
        private Node next;

        public Node(K data) {
            this.data = data;
        }
    }
}
