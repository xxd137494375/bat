package two.two_16_paixu4;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/1412:44
 */
public class two_19_Subsequence {
    /*
        最短子数组

        对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。

        给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。

        测试样例：
        [1,4,6,5,9,10],6
        返回：2
     */

    /**
     * 理解错误，这是错误的答案，根本没有理解题目的思路
     * @param A
     * @param n
     * @return
     */
    public static int shortestSubsequence(int[] A, int n){
        int result=0;
        int max=A[0];
        int min=A[n-1];
        int right=0;
        int left=n-1;
        for(int i=1;i<n;i++){//找到左边的一个极大值
            if(A[i]<A[i-1]){
                max=A[i-1];
                right=i-1;
                break;
            }
        }
        for(int i=n-1;i>0;i--){//找到右边的一个极小值
            if(A[i]<A[i-1]){
                min=A[i];
                left=i;
                break;
            }
        }
//      System.out.println(right+"--"+left);
        System.out.println(max+"--"+min);
//        for(int i=right+1;i<n;i++){//找到连续小于max的最右位置
//            if(A[i]>max){
//                break;
//            }
//            right++;
//        }
//        for(int i=left-1;i>0;i--){//找到连续大于min的最左位置
//            if(A[i]<min){
//                break;
//            }
//            left--;
//        }
        System.out.println(right+"--"+left);
        result = right-left+1;
        if(result<0)result=0;
        return  result;
    //[1,2,10,1,8,9],6
    }


    //     [1,4,6,5,9,10],6
    //        返回：2

    /**
     *
     * @param A
     * @param n
     * @return
     */
    public static int shortestSubsequence1(int[] A, int n) {
        int max = A[0], min = A[n - 1], r = 0, l = 0;
        for (int i = 0; i < n; i++) {//找到需要排序的最右边，保证最右边的一小部分均保证在最后排序完的位置是一致的，目的是找到最右边一个会小于前面的数
            if (A[i] > max){
                max = A[i];
            }
            else if (A[i] < max) {
                r = i;
            }
        }
        for (int j = n - 1; j >= 0; j--){//找到需要排序的最左边，保证最左边的一小部分均保证在最后的位置是一致的，目的是找到最左边一个会大于后面的数
            if (A[j] < min) {
                min = A[j];
            }
            else if (A[j] > min) {
                l = j;
            }
        }
        System.out.println(min+"-"+max);
        System.out.println(r);
        System.out.println(l);
        if (r - l == 0) return 0;
        else return r - l + 1;
    }
    public static void main(String[] args){
        int [] A ={1,2,298276,264461,21251,171315,164437,199777,125199,303029,303030};
        //              2                                          8
        int [] B={1,4,6,5,9,10};
        int [] C={1,2,10,1,8,9};
        int [] D={1 ,3 ,4 ,7 ,6 ,8 ,9 ,3 ,2 ,0 ,10 ,12};
        shortestSubsequence1(D,D.length);

    }
}
