package all.javalearn.datastructure.arithmetic;

/**
 * @author by shudebao@tal.com
 * @description
 * @date 2021/10/22 11:44 上午
 */
public class TreeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.value = 1;

        root.left = new TreeNode();
        root.left.value = 2;
        root.right = new TreeNode();
        root.right.value = 3;

        root.left.left = new TreeNode();
        root.left.left.value = 4;
        root.left.right = new TreeNode();
        root.left.right.value = 5;

        root.right.left = new TreeNode();
        root.right.left.value = 6;
        root.right.right = new TreeNode();
        root.right.right.value = 7;

        root(root);
    }

    /**
     *          1
     *        2   3
     *      4  5 6  7
     */
    public static void root(TreeNode root) {
        if (root == null) return;
        //前序遍历 1245367
//        System.out.print(root.value);
        root(root.left);
        //中序遍历 4251637
//        System.out.print(root.value);
        root(root.right);
        //后序遍历 4526731
        System.out.print(root.value);
    }


    /**
     * 力扣104 二叉树的最大深度
     */
    static int result;
    static int length;
    public static int maxDegree(TreeNode root) {
        if (root == null) {
            result = Math.max(result, length);
        }
        length++;
        maxDegree(root.left);
        maxDegree(root.right);
        length--;
        return result;
    }

    /**
     * 力扣 226反转二叉树
     * 前序或者后序都可，为啥中序不可 todo
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
     * 力扣116
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
     * 力扣114
     * 把一棵树转化成一个链表
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        TreeNode p = root.right;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    /**
     * 力扣654 构建最大二叉树
     * @return
     */
    public static TreeNode getMax(int[] arr) {
        int maxIndexOfArr = 0 ;//找出数组最大数的索引，略
        TreeNode root = new TreeNode();
        root.value = arr[maxIndexOfArr];
        int[] left = null;//最大数左边的数组，略
        int[] right = null;//最大数右边的数组，略
        root.left = getMax(left);
        root.right = getMax(right);
        return root;
    }

    /**
     * 力扣105
     * 通过前序和中序遍历结果构造二叉树
     * @return
     */
    public static TreeNode build(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode();
        root.value = rootVal;
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }

    TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    /**
     * 106 通过后序和中序遍历结果构造二叉树
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param postorder
     * @param postStart
     * @param postEnd
     * @return
     */
    public static TreeNode build2(int[] inorder, int inStart, int inEnd,
                                 int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode();
        root.value = rootVal;
        // 递归构造左右子树
        root.left = build2(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = build2(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }


    /**
     * 886 通过后序和前序遍历结果构造二叉树
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param postorder
     * @param postStart
     * @param postEnd
     * @return
     */
    TreeNode build3(int[] preorder, int preStart, int preEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // root.left 的值是前序遍历第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int leftRootVal = preorder[preStart + 1];
        // leftRootVal 在后序遍历数组中的索引
        int index = 0;
        for (int i = postStart; i < postEnd; i++) {
            if (postorder[i] == leftRootVal) {
                index = i;
                break;
            }
        }
        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = build3(preorder, preStart + 1, preStart + leftSize,

                postorder, postStart, index);
        root.right = build3(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);

        return root;
    }



    static class TreeNode {
        private Integer value;
        private TreeNode left;
        private TreeNode right;
        //
        private TreeNode next;

        public TreeNode() {
        }

        public TreeNode(Integer value) {
            this.value = value;
        }
    }
}
