package four.four_7_stackandqueue3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ：xingxiangdong
 * @Date :2019/6/323:13
 */
public class four_8_SlideWindow {
    /*
        滑动窗口练习题

        有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。

        给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。

        测试样例：
        [4,3,5,4,3,3,6,7],8,3
        返回：[5,5,5,4,6,7]
     */
    public static int[] slide(int[] arr, int n, int w) {
        // write code here
        int[] res=new int[n-w+1];
        int index=0;
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(q.isEmpty()){
                q.add(i);
            }else{
                if(arr[i]<arr[q.getLast()]){
                    q.add(i);
                }else{
                    while(!q.isEmpty()&&arr[i]>=arr[q.getLast()]){
                        q.removeLast();
                    }
                    q.add(i);
                }
            }
            if(q.getFirst()<i-w+1){
                q.removeFirst();
            }
            if(i>=w-1){
            res[index++]=arr[q.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(slide(arr,8,3)));

    }
}
