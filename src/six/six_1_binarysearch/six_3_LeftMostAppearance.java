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
    public static int findPos(int[] arr, int n, int num) throws Exception {

        // write code here[36,62,146,208,210,369,616],7,616
        int left = 0;
        int right = n - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] == num) {

                right = mid - 1;
                res = mid;
                if (left == right && arr[left] != num) {
                    return res;
                }

            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
//        int[] arr = {36, 62, 146, 208, 210, 369, 616};
        int[] arr = {1, 1, 7, 12, 14, 23, 33, 37, 45, 59, 59, 61, 62, 67, 69, 76, 77, 81, 83, 86, 98, 99, 99, 102, 105, 106, 112, 118, 119, 125, 131, 132, 137, 141, 141, 142, 145, 159, 161, 161, 161, 165, 173, 180, 181, 183, 184, 189, 190, 212, 222, 223, 223, 229, 241, 243, 244, 247, 247, 254, 255, 255, 258, 259, 260, 267, 272, 273, 276, 277, 283, 288, 291, 293, 294, 296, 297, 297, 300, 302, 309, 312, 312, 316, 318, 323, 327, 329, 334, 334, 341, 349, 349, 351, 354, 365, 377, 377, 377, 378, 379, 386, 387, 387, 391, 394, 405, 416, 418, 418, 423, 424, 425, 427, 428, 429, 431, 434, 435, 443, 443, 444, 452, 455, 465, 477, 484, 489, 493, 493, 502, 505, 507, 517, 521, 527, 528, 546, 548, 548, 551, 551, 555, 556, 562, 572, 581, 595, 605, 613, 620, 627};
        System.out.println(findPos(arr, 152, 1));
    }
}
