package all.javalearn.datastructure.arithmetic;

/**
 * @author by shudebao@tal.com
 * @description
 * @date 2021/10/22 11:44 上午
 */
public class TreeTest {

    public static void main(String[] args) {

    }

    /**
     * 反转二叉树
     * @param root
     * @return
     */
    public static TreeNode reverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        reverse(root.left);
        reverse(root.right);
        return root;
    }

    /**
     * 完美二叉树，填充next指针，让这一个指针指向其下一个右侧节点，如果找不到指向null
     * @param root
     * @return
     */
    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectTwo(root.left, root.right);
        return root;
    }

    private static void connectTwo(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTwo(node1.left, node1.right);
        connectTwo(node2.left, node2.right);
        connectTwo(node1.right, node2.left);

    }

    /**
     * 把一棵树转化成一个链表
     * @param root
     */
    public static void flatten(TreeNode root) {

    }


    static class TreeNode {
        private Integer value;
        private TreeNode left;
        private TreeNode right;
        //
        private TreeNode next;
    }
}
