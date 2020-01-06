package seven.seven_1_BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归 二叉树遍历
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/521:19
 */
public class seven_3_TreeToSequence2 {
    public int[][] convert(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preOrder(root, pre);
        postOrder(root, post);
        midOrder(root, mid);
        int[] prearr = listToArray(pre);
        int[] midarr = listToArray(mid);
        int[] postarr = listToArray(post);
        int[][] result = {prearr, midarr, postarr};
        return result;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode cur = null;
        while (!s.isEmpty()) {
            cur = s.pop();
            res.add(cur.val);
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
    }

    public void midOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode node = null;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                node = s.pop();
                res.add(node.val);
                cur = node.right;
            }
        }
    }

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode cur = root;
        s1.push(cur);
        while (!s1.isEmpty()) {
            cur = s1.pop();
            if (cur.left != null) {
                s1.push(cur.left);
            }
            if (cur.right != null) {
                s1.push(cur.right);
            }
            s2.push(cur);
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
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
