package seven.seven_1_BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归二叉树的序列打印
 * <p>
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * <p>
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/515:41
 */
public class seven_2_TreeToSequence {
    public int[][] convert(TreeNode root) {
        // write code here
        List<Integer> pre = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preOrder(root, pre);
        midOrder(root, mid);
        postOrder(root, post);
        int[] prearr = listToArray(pre);
        int[] midarr = listToArray(mid);
        int[] postarr = listToArray(post);
        int[][] res = {prearr, midarr, postarr};
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public void midOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        midOrder(root.left, res);
        res.add(root.val);
        midOrder(root.right, res);
    }

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    public int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
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
