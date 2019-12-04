package two.two_16_paixu4;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/1523:16
 */
public class two_20_Gap {
    /*r
        有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。

        给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。

        测试样例：
        [1,2,5,4,6],5
        返回：2
     */
    public int maxGap(int[] A, int n) {
        // write code here
        int result=0;
        int min=A[0];
        int max=A[0];
        for(int i=0;i<n;i++){
            if(A[i]<min){
                min=A[i];
            }
            if(A[i]>max){
                max=A[i];
            }
        }
        double gap = (max-min)/n;
        int[] bucket = new int [n];//桶
        int[] count =new int[n+1];//为入桶做辅助作用
        int[] tempcount =new int[n+1];//为入桶做辅助作用
//        double left=min;
//        double right=left+gap;
//        int index=0;
//        for(;left<max;index++,left+=gap){
//            for(int i=0;i<n;i++){
//                if(A[i]>=left&&A[i]<right){
//                    count[index]++;
//                }
//            }
//            index++;
//            left+=gap;
//            right+=gap;
//        }
        for(int i=0;i<n;i++){
            int a= (int) ((A[i]-min)/gap);
            count[a]++;
        }
        for(int i=0;i<n+1;i++){//保存每个桶的个数
            tempcount[i]=count[i];
        }
        for(int i=1;i<n+1;i++){//记录每个桶最右边的索引
            count[i]=count[i]+count[i-1];
        }
        for(int i=n-1;i>=0;i++){
            int num=getIndex(A[i],min,gap);
            bucket[count[num]-1]=A[i];
            count[num]--;
        }
        return result;
    }
    public int getIndex(int num,int min,double gap){
        return (int) ((num-min)/gap);
    }


    /**
     * 答案，借用桶排序
     * @param nums
     * @param N
     * @return
     */
    public int maxGap1(int[] nums,int N) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {//找到min和max
            min = Math.min(min, nums[i]);
            //   if(nums[i]>max){
            //                max=nums[i];
            //            }
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];//标记每个桶是否有数字
        int[] maxs = new int[len + 1];//这一步太妙了，我们只想到建立一个二维数组，这里可以直接建两个一维数组。比较直观。
        int[] mins = new int[len + 1];
        int bid = 0;//桶号
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max); // 算出桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];//如果没数就直接把这个数放入最大和最小值
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = 0;
//        int i = 0;
//        while (i <= len) {
//            if (hasNum[i++]) { // 找到第一个不空的桶
//                lastMax = maxs[i - 1];
//                break;
//            }
//        }
        int i = 1;//因为第一个桶肯定不是空，则上面可以换成这两句。
        lastMax=maxs[0];
        //扫一遍桶，
        for (; i <= len; i++) {
            if (hasNum[i]) {//空桶会掠过去
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // 使用long类型是为了防止相乘时溢出
    public int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
