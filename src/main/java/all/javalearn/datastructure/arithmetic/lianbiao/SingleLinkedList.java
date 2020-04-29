//package all.javalearn.datastructure.arithmetic.lianbiao;
//
//public class SingleLinkedList<K>
//{
//    private int size;
//    private Node<K> head;
//
//    public SingleLinkedList() {
//        this.size = 0;
//        this.head = null;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public Node getHead() {
//        return head;
//    }
//
//    public void setHead(Node head) {
//        this.head = head;
//    }
//
//
//
//    /**
//     * 删除指定的元素,假设node一定存在
//     */
//    public boolean delete(Node node)
//    {
//        Node next = node.next;
//        if (next == null){
//            node = null;
//        } else {
//            node.data = next.data;
//            node.next = next.next;
//        }
//        return true;
//    }
//
//
//    //反转
//    public Node reverse(Node oldHead)
//    {
//        //递归
//        if (oldHead == null || oldHead.next == null) return oldHead;
//        Node reverse = reverse(oldHead.next);
//        Node temp = oldHead;
//        oldHead = oldHead.next.next;
//
//
//
//
//
//
//        Node add = new Node("null");
//        add.next = head;
//
//        Node addSecond = head;
//        Node addThird = head.next;
//        while (addSecond != null)
//        {
////            Node temp =
//            addSecond = addThird;
//            addThird = addThird.next;
//            add.next = addSecond;
//            addSecond.next = addThird;
//        }
//    }
//
//    class Node<K>
//    {
//        private K data;
//        private Node next;
//
//        public Node(K data) {
//            this.data = data;
//        }
//    }
//}
