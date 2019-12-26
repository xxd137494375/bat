package three.three_1_string1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/1916:45
 */
public class three_2_IdenticalTree {
    /*
        拓扑结构相同子树

        对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。

        给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
     */
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        pre(A,sb1);
        pre(B,sb2);
        return sb1.toString().contains(sb2.toString());

        // write code here
    }
    public void pre(TreeNode root,StringBuilder builder){
        if(root==null){
            builder.append("(#)");   //对每个值加括号是为了防止  出现  12  和 2 这种情况，如果只加结束标识符  12！  2！ 在进行判断时实际返回的是true
        }else{
            //注意递归边界：如果当前结点不是null则递归左右儿子；如果不判断当前结点是否为空，则在递归到null时出现空指针异常
            builder.append("("+root.val+")");
            pre(root.left,builder);
            pre(root.right,builder);
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        TreeNode t = new TreeNode(7);
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t1.left=t2;
        t1.right=t3;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        three_2_IdenticalTree a =new three_2_IdenticalTree();
        a.pre(t1,sb1);
        a.pre(t,sb2);
        String s1=sb1.toString();
        String s2 = sb2.toString();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.contains(s2));
    }
}
