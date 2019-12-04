package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/911:48
 */

public class two_2_BubbleSort {
    /*
        对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。

        给定一个int数组A及数组的大小n，请返回排序后的数组。

        测试样例：[1,2,3,5,2,3],6
        [1,2,2,3,3,5]
     */
    public class BubbleSort {
        public int[] bubbleSort(int[] A, int n) {
            // write code here
            if (n == 0 || n == 1) return A;
            boolean flag = true;
            for (int i = 0; i < n && flag; i++) {
                flag = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (A[j] > A[j + 1]) {
                        flag = true;
                        int temp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = temp;
                    }
                }
            }
            return A;
        }
    }
}
