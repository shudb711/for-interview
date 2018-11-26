package all.javalearn.datastructure.linkedlist.singlepoint;

public class LinkedTest {
    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add("A");
        singleList.add("B");
        singleList.add("C");
        singleList.add("D");

        System.out.println(singleList.getSize());
//        singleList.deleteHead();
        boolean b1 = singleList.delete("b");
        boolean b = singleList.delete("B");
        boolean d = singleList.delete("D");

        System.out.println(singleList.getSize());

        SingleLinkedList.Node c = singleList.find("C");
        System.out.println(c);
    }
}
