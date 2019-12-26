package four.four_3_stackandqueue2;

import java.util.Stack;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/3119:40
 */
public class four_4_TwoStack {
    /*
        双栈队列

        编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。

        给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。

        测试样例：
        [1,2,3,0,4,0],6
        返回：[1,2]
     */

    public int[] twoStack(int[] ope, int n) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int popnum = 0;
        for(int i=0;i<n;i++){
            if(ope[i]>0){
                stack1.push(ope[i]);
            }
            if(ope[i]==0){
                popnum++;
            }
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int [] res  = new int[popnum];
        for(int i=0;i<popnum;i++){
            res[i]=stack2.pop();
        }
        return res;
    }


}
