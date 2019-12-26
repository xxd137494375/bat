package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/911:53
 */
public class two_5_mergeSort {
    /*
         对于一个int数组，请编写一个归并排序算法，对数组元素排序。

        给定一个int数组A及数组的大小n，请返回排序后的数组。
     */

    public int[] mergeSort(int[] A, int n){
        // write code here
        sort(A,0,n-1);
        return A;
    }

    public void sort(int[] A,int left,int right){
        int mid = (left+right)>>1;
    }
}
