package all.javalearn.datastructure.arithmetic;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author by shudebao@tal.com
 * @description
 * @date 2021/10/19 10:10 上午
 */
public class LinkedListTest {

    public static void main(String[] args) {

    }


    /**
     * 力扣 141 是否环形链表
     * @param listNode
     * @return
     */
    public boolean isCycle(ListNode listNode) {
        ListNode fast,slow;
        fast = slow = listNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 力扣 142
     * 获取环形链表起始位置
     * @param listNode
     * @return
     */
    public ListNode cycleBegin(ListNode listNode) {
        ListNode fast, slow;
        fast = slow = listNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = listNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 力扣 876，链表的中点
     * @param head
     * @return
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 力扣 19，删除链表倒数第n个元素
     * @param head
     */
    public static void deleteReverseN(ListNode head, int n) {
        ListNode fast,slow;
        fast = slow = head;
        ListNode nBefore = null;
        int i = 0;
        while (fast != null) {
            fast = fast.next;
            i++;
            if (i == n) {
                nBefore = slow;
                slow = slow.next;
            }
        }
        nBefore.next = slow.next;

    }

    /**
     * 力扣21  合并两个有序链表
     * @param listNode1
     * @param listNode2
     * @return
     */
    public static ListNode mergeTwo(ListNode listNode1, ListNode listNode2) {
        if (Objects.isNull(listNode1)) {
            return listNode2;
        }

        if (Objects.isNull(listNode2)) {
            return listNode1;
        }

        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = listNode1, p2 = listNode2;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    /**
     * 力扣23 合并N个有序链表
     * 思路1：合并两个链表，结果作为一个新链表，然后再把这个新链表和下一个链表合并，再合并成一个新链表，如此反复
     *  时间复杂度：O(n^2*k) 空间复杂度：O(1)
     * 思路2：两两分别合并成新链表，合并后的新链表两两再次合并，如此反复，知道最后合并成1个链表
     *  时间复杂度：O(nk*logn) 空间复杂度：O(logn)
     * @param lists
     * @return
     */
    public static ListNode mergeN(ListNode[] lists) {
        if (lists == null ) return null;
        if (lists.length == 1) return lists[1];
        ListNode begin = lists[0];
        for (int i = 0; i < lists.length - 1; i++) {
            begin = mergeTwo(begin, lists[i + 1]);
        }
        return begin;
    }
    public static ListNode mergeN(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }

        if (begin > end) {
            return null;
        }

        int middle = (begin + end) / 2;
        return mergeTwo(mergeN(lists, begin, middle), mergeN(lists, middle + 1, end));
    }


    /**
     * 获取倒数第k个节点
     * O(n)
     * @param head
     * @param k
     * @return
     */
    public static ListNode findKFromEnd(ListNode head, int k) {
        int i = 0;
        ListNode node = head, kNode = null;
        while (node != null && i < k) {
            node = node.next;
            i++;
        }

        while (node != null) {
            node = node.next;
            kNode = head.next;
        }
        return kNode;
    }

    /**
     * 力扣160 获取两个节点相交的节点
     * @param node1
     * @param node2
     * @return
     */
    public ListNode getIntersactionNode(ListNode node1, ListNode node2) {
        ListNode p1 = node1, p2 = node2;
        while (true) {
            if (p1 == null) {
                p1 = node2;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = node1;
            } else {
                p2 = p2.next;
            }
            if (p1 == p2) {
                return p1;
            }
        }
    }


    /**
     * 力扣206 反转整个链表（迭代）
     * @param head
     * @return
     */
    public static ListNode reverseIterator(ListNode head) {
        ListNode current = head, before = null;
        while (current.next != null) {
            before = current;
            current = current.next;
            current.next = before;
        }
        return current;
    }

    /**
     * 反转整个链表（递归）todo
     * @param head
     * @return
     */
    public static ListNode reverseRecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 反转前n个 todo
     * @param head
     * @param n
     * @return
     */
    static ListNode successor = null;
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        last.next = successor;
        return last;
    }

    /**
     *  反转m到n节点 todo
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        return null;
    }

    /**
     * k个一组，反转列表，少于k个不反转
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKgroup(ListNode head, int k) {
        return null;
    }

    /**
     * 力扣234  判断是否是回文链表
     * @param head
     * @return
     */
    static ListNode left;
    public static boolean isPalindrome(ListNode head) {
        //方式1：存入数组，头尾走向中心判断
        //方式2：递归
        left = head;
        return traverse(head);
        //方式3：反转后面半部分
    }
    public static boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean traverse = traverse(right.next);
        traverse = traverse && (right.value == left.value);
        left = left.next;
        return traverse;
    }




    static class ListNode {
        private Integer value;
        private ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }
    }


}
