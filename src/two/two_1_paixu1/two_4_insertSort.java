package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/911:49
 */
public class two_4_insertSort {
    /*
        对于一个int数组，请编写一个插入排序算法，对数组元素排序。

        给定一个int数组A及数组的大小n，请返回排序后的数组。
         测试样例：[1,2,3,5,2,3],6
        [1,2,2,3,3,5]
     */
    public int[] insertionSort(int[] A, int n) {
        // write code here
        int i,j,temp;
        for(i=1;i<n;i++){
            if(A[i]<A[i-1]){
            temp=A[i];
            for(j=i-1;j>=0&&A[j]>temp;j--){
                A[j+1]=A[j];
            }
            A[j+1]=temp;
            }
        }
        return A;
    }
}
