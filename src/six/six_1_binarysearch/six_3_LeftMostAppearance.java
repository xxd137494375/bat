package six.six_1_binarysearch;

/**
 * 元素最左出现
 * <p>
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * <p>
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * <p>
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/3020:49
 */
public class six_3_LeftMostAppearance {
    public static int findPos(int[] arr, int n, int num) {
        // write code here[36,62,146,208,210,369,616],7,616
        int left = 0;
        int right = n - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] == num) {
                right = mid;
                res = mid;
                if (left == right) {
                    return res;
                }
            } else {
                right = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {36, 62, 146, 208, 210, 369, 616};
        System.out.println(findPos(arr, 7, 616));
    }
}
