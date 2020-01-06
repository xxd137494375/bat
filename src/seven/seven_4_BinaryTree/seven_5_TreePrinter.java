package seven.seven_4_BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树层次遍历
 * <p>
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * <p>
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/615:38
 */
public class seven_5_TreePrinter {
    /**
     * self: 关键点在于 引入last和nlast两个变量 last表示当前行的最后一个元素， nlast表示下一行的最后一个节点， 当遍历完一行时将last指向nlast
     *
     * @param root
     * @return
     */
    public int[][] printTree(TreeNode root) {
        // write code here.
        if (root == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nlast = root;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            root = queue.removeFirst();
            list.add(root.val);
            if (root.left != null) {
                queue.addLast(root.left);
                nlast = root.left;
            }
            if (root.right != null) {
                queue.addLast(root.right);
                nlast = root.right;
            }
            if (root == last) {
                last = nlast;
                result.add(list);
                list = new ArrayList<>();
            }
        }
        int[][] res = new int[result.size()][];
        for (int i = 0; i < res.length; i++) {
            list = result.get(i);
            int[] l = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                l[j] = list.get(j);
            }
            res[i] = l;
        }
        return res;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
