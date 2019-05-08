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
}
