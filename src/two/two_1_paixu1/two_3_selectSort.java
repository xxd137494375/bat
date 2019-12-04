package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/912:24
 */
public class two_3_selectSort {
    /*
    对于一个int数组，请编写一个选择排序算法，对数组元素排序。

    给定一个int数组A及数组的大小n，请返回排序后的数组。
     测试样例：[1,2,3,5,2,3],6
    [1,2,2,3,3,5]
 */
    public int[] selectionSort(int[] A, int n) {
        // write code here
        int min;
        for(int i=0;i<n;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[min])min=j;
            }
            int temp=A[i];
            A[i]=A[min];
            A[min]=temp;
        }
        return A;
    }
}
