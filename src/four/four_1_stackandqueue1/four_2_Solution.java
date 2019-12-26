package four.four_1_stackandqueue1;

import java.util.Stack;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/2921:17
 */
public class four_2_Solution {
    /*
        可查询最值的栈

         定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
     */
    /**
        stackdata
     */
    Stack<Integer> stackdata = new Stack<>();
    /**
     stackmin
     */
    Stack<Integer> stackmin = new Stack<>();
    public void push(int node) {
        stackdata.push(node);
        if(stackmin.isEmpty()){
            stackmin.push(node);
        }else {
            if(node<=stackmin.peek()){
                stackmin.push(node);
            }
        }
    }
    public void pop() {
        if(stackdata.peek().equals(stackmin.peek())){
            stackmin.pop();
        }
        //注意这个要放在上面if语句的后面。
        stackdata.pop();
    }

    public int top() {
        return stackdata.peek();
    }

    public int min() {
        return stackmin.peek();
    }
    /**
     * 方法二：更费空间，更省时间
     * @param node
     */
    public void push1(int node) {
        stackdata.push(node);
        if(stackmin.isEmpty()){
            stackmin.push(node);
        }else {
            //善用java的内置函数，可以看出熟练度
            stackmin.push(Math.min(node,stackmin.peek()));
        }
    }

    public void pop1() {
        stackdata.pop();
        stackmin.pop();
    }

    public int top1() {
        return stackdata.peek();
    }

    public int min1() {
        return stackmin.peek();
    }
}
