package seven.seven_7_BinaryTree;

import java.util.LinkedList;

/**
 * 完全二叉树判断
 * <p>
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * <p>
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/1422:31
 */
public class seven_9_CheckCompletion {
    public boolean chk(TreeNode root) {
        // write code here

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.addLast(root);
        int i = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            i = 0;
            if (node.left == null && node.right != null) {
                return false;
            }
            if (flag && i != 0) {
                return false;
            }
            if (node.left != null) {
                queue.addLast(node.left);

            }
            if (node.right != null) {
                queue.addLast(node.right);

            } else {
                flag = true;
            }

        }

        return true;
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
