package six.six_5_binarysearch;

/**
 * 最左原位 arr[i] = i 最小的i
 * <p>
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 * <p>
 * 给定有序数组arr及它的大小n，请返回所求值。
 * <p>
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/316:22
 */
public class six_6_Find {
    public static int findPos(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }


    public static int findPos2(int[] arr, int n) {
        if (arr[0] > n) {
            return -1;
        }
        if (arr[n - 1] < 0) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = n - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > mid) {
                right = mid - 1;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}
