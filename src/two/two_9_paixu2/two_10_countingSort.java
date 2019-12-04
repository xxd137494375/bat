package two.two_9_paixu2;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/622:37
 */
public class two_10_countingSort {
    /*
        对于一个int数组，请编写一个计数排序算法，对数组元素排序。

        给定一个int数组A及数组的大小n，请返回排序后的数组。

        测试样例：
     */

    public int[] countingSort(int[] A, int n) {
        // write code here
        int min=A[0];
        int max=A[0];
        for(int i=0;i<n;i++){
            if(A[i]<min)min=A[i];
            if(A[i]>max)max=A[i];
        }
        int[] count = new int [max-min+1];
        for(int i=0;i<n;i++){
            count[A[i]-min]++;
        }
        int index=0;
        for(int i =0;i<count.length;i++){
            while(count[i]--!=0){
                A[index++]=i+min;
            }
        }
        return A;
    }
}
