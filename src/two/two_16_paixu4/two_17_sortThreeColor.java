package two.two_16_paixu4;

import java.util.Arrays;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/921:16
 */
public class two_17_sortThreeColor {
    /*
        有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。

        给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
        测试样例：
        [0,1,1,0,2,2],6
        返回：[0,0,1,1,2,2]
     *///[1,2,0,2]
    public static int[] sortThreeColor(int[] A, int n) {
        if (A == null || A.length < 2) {
            return A;
        }
        int left = -1;
        int index = 0;
        int right = A.length;
        while (index < right) {
            if (A[index] == 0) {
                swap(A, ++left, index++);
            } else if (A[index] == 2) {
                swap(A, index, --right);
            } else {
                index++;
            }
        }
        return A;
    }

    public static void swap(int[]A,int i,int j ){
        int temp = A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    public static void main(String[] args) {
        int [] A ={1,2,0,2};
        sortThreeColor(A,4);
        System.out.println(Arrays.toString(A));

    }
}
