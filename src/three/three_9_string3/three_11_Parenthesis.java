package three.three_9_string3;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/248:29
 */
public class three_11_Parenthesis {
    /*
        合法括号序列判断
        对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。

        给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。

        测试样例：
        "(()())",6
        返回：true
        测试样例：
        "()a()()",7
        返回：false
        测试样例：
        "()(()()",7
        返回：false
     */
    //这道题的题目好像有点问题
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        int count=0;
        int len = A.length();
        for(int i=0;i<len;i++){
            if(A.charAt(i)=='(')count++;
            if(A.charAt(i)==')')count--;
            if(count<0)return false;
        }
        if(count!=0)return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(chkParenthesis(")(",2));
    }
}
