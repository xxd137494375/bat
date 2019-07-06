package four.four_3_stackandqueue2;

import java.util.Stack;

/**
 * @Author ：xingxiangdong
 * @Date :2019/6/29:56
 */
public class four_6_twoStacksSort {
    /*
        双栈排序：

        请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。

        给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。

        测试样例：
        [1,2,3,4,5]
        返回：[5,4,3,2,1]
     */
    public static Stack<Integer> twoStacksSort(Stack<Integer> A) {
        // write code here
        Stack<Integer> help = new Stack<>();

        while(!A.isEmpty()){
            int apop = A.pop();
            if(help.isEmpty()){
                help.push(apop);
            }else {
                int hpop  = help.pop();
                if(apop<=hpop){
                    help.push(hpop);
                    help.push(apop);
                }else {
                    help.push(apop);
                    help.push(hpop);
                }
            }
        }
        while(!help.isEmpty()){
            A.push(help.pop());
        }

        return A;
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(twoStacksSort(s).toString());
    }
}
