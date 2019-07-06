package four.four_3_stackandqueue2;

import java.util.Stack;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/3121:55
 */
public class four_5_StackReverse {
    /*
        栈的反转

        实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。

        给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。

        测试样例：
        [4,3,2,1],4
        返回：[1,2,3,4]
     */

    public static Stack<Integer> reverseStack(Stack<Integer> A, int n) {
        // write code here
        if(A.isEmpty())return A;
        int res = get(A);
        reverseStack(A,--n);
        A.push(res);
        return A;
    }

    public static int  get(Stack<Integer> A){
        int res = A.pop();
        if(A.isEmpty()){
            return res;
        }else{
            int last=get(A);
            A.push(res);
            return last;
        }
    }



}
