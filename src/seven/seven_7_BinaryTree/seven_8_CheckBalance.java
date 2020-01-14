package seven.seven_7_BinaryTree;


/**
 * 平衡二叉树判断
 * <p>
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * <p>
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/1421:43
 */
public class seven_8_CheckBalance {
    public boolean check(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return check(root.left) && check(root.right);

    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return Math.max(lh, rh) + 1;

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
