package six.six_1_binarysearch;

/**
 * 循环有序数组最小值
 * <p>
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * <p>
 * 给定数组arr及它的大小n，请返回最小值。
 * <p>
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/312:28
 */
public class six_4_MinValue {
    public static int getMin(int[] arr, int n) {
        // write code here
        int left = 0;
        int right = n - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[left] < arr[right]) {
                return arr[left];
            } else {
                if (arr[left] > arr[mid]) {
                    right = mid;
                } else if (arr[mid] > arr[right]) {
                    left = mid + 1;
                } else {
                    int min = arr[0];
                    for (int i = 0; i < n; i++) {
                        if (arr[i] < min) {
                            min = arr[i];
                        }
                    }
                    return min;
                }
            }
        }
        return arr[left];
    }
}
