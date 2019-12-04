package two.two_12_paixu3;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/813:31
 */
public class two_15_Merge {
    /*
        有序数组合并练习

        有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
        给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
     */

    /**
     * very easy
     *
     * 注意点：只要B放完了 就可以结束了
     * @param A
     * @param B
     * @param n
     * @param m
     * @return
     */
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        // write code here
        int i=n-1;
        int j=m-1;
        int index=m+n-1;
        while(i>=0&&j>=0){
            if(A[i]>=B[j])A[index--]=A[i--];
            else A[index--]=B[j--];
        }
//        while(i>=0){
//            A[index--]=A[i--];  因为最后是放到A中所以最后不用再做这一步
//        }
        while(j>=0){
            A[index--]=B[j--];
        }
        return A;
    }

    /**
     * 优化上面的方法
     * @param A
     * @param B
     * @param n
     * @param m
     * @return
     */
    public int[] mergeAB2(int[] A, int[] B, int n, int m) {
        // write code here
        while(m>0&&n>0){
            if(A[n-1]>=B[m-1])A[m+n-1]=A[--n];   //A[--n];   等价于   A[n-1]; n--;
            else A[m+n-1]=B[--m];
        }
        while(m>0){
            A[m+n-1]=B[--m];
        }
        return A;
    }
    /**
     * 答案：省略3个变量 ：不用变量就要想到用入参来做数组的下标
     */
    public int[] mergeAB1(int[] A, int[] B, int n, int m) {
        while (m != 0) {
            if (n == 0) {
                A[m +n - 1] = B[m - 1];
                m--;
            } else {
                A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
                //通俗一点   A[m+n-1]=A[n-1]>B[m-1]?A[n-1]:B[m-1];  n--; m--
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,3,7,0,0,0};
        int[] B ={2,4,6};
        two_15_Merge r = new two_15_Merge();
        int[] ints = r.mergeAB(A,B,3,3);
        for(int num : ints){
            System.out.println(num);
        }
    }
}
