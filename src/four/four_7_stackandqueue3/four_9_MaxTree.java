package four.four_7_stackandqueue3;

import java.util.Stack;

/**
 * @Author ：xingxiangdong
 * @Date :2019/7/123:01
 */
public class four_9_MaxTree {
    /*
        数组变树问题

        对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，其中的节点与数组元素一一对应，
        同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组
        中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。

        给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
        测试样例：
        [3,1,4,2],4
        返回：[2,0,-1,2]
     */
    public static int[] buildMaxTree(int[] A, int n) {

        // write code here
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();
        left[0] = A[0];
        s.push(A[0]);
        for (int i = 1; i < n; i++) {//找到每个数左边第一个大于它的数什么？如果没有则是它本身。
            if(s.peek()>A[i]){
                left[i]=s.peek();
                s.push(A[i]);
            }
            else{
                while(!s.isEmpty()&&s.peek()<A[i]){
                    s.pop();
                    if(s.isEmpty()){
                        break;
                    }
                }
                if(s.isEmpty()){
                    left[i]= A[i];//以辅助数组和原数组是否相等判断是否为null;
                    s.push(A[i]);
                    continue;
                }
                left[i]=s.peek();
                s.push(A[i]);
            }
        }
        right[n-1]=A[n-1];
        s.push(A[n-1]);
        for(int i = n-2;i>=0;i--){
            if(s.peek()> A[i]){
                right[i]=s.peek();
                s.push(A[i]);
            }
            else{
                i=i+0;
                while (!s.isEmpty()&&s.peek()<A[i]){
                    s.pop();
                    if(s.isEmpty()){
                        break;
                    }
                }
                if(s.isEmpty()){
                    right[i]=A[i];
                    s.push(A[i]);
                    continue;
                }
                right[i]=s.peek();
                s.push(A[i]);
            }
        }

        for(int i=0 ; i<n ;i++){
            if(A[i]==left[i]&&A[i]==right[i]){
                res[i] = -1;
                continue;
            }
            if(A[i]==left[i]&&A[i]!=right[i]){
                res[i] = getIndex(A,right[i]);
                continue;
            }
            if(A[i]!=left[i]&&A[i]==right[i]){
                res[i] = getIndex(A,left[i]);
                continue;
            }
            res[i]=getIndex(A,Math.min(left[i],right[i]));
        }

//        System.out.println();
//        for(int i:left){
//            System.out.print(i+"  ");
//        }
//        System.out.println("");
//        for(int i:right){
//            System.out.print(i+"  ");
//        }
        return res;
    }
    public static int getIndex(int[] A,int num){
        int res=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==num)return i;
        }
        return res;
    }

    public static void main(String[] args) {
        int [] A = {36,1173,934,436};//[1,-1,1,2]

        buildMaxTree(A,4);
    }
}
