package seven.seven_10_BinaryTree;

import java.util.ArrayList;

/**
 * 寻找错误结点
 * <p>
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
 * <p>
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/1523:32
 */

/**
 * 关键点在于：平衡二叉树的中序遍历是一个排序后的序列 。  对于一个排序序列交换两个值变成了一个不是排序的序列， 请找出交换的两个值是多少。 大的值为第一次出现降序较大的值，小的值为最后一次出现降序较小的值。
 */
public class seven_12_FindErroNode {
    public int[] findError(TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        mid(root, list);
        int[] res = new int[2];
        boolean flag = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (flag && list.get(i) > list.get(i + 1)) {
                res[1] = list.get(i);
                res[0] = list.get(i + 1);
                flag = false;
                continue;
            }
            if (!flag && list.get(i) > list.get(i + 1)) {
                res[0] = list.get(i + 1);
                break;
            }
        }
        return res;
    }

    public void mid(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        mid(root.left, list);
        list.add(root.val);
        mid(root.right, list);
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
