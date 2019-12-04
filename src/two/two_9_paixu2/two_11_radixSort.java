package two.two_9_paixu2;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/920:35
 */
public class two_11_radixSort {
    /*
        基数排序
        对于一个int数组，请编写一个基数排序算法，对数组元素排序。

        给定一个int数组A及数组的大小n，请返回排序后的数组。保证元素均小于等于2000。
     */
    public int[] radixSort(int[] A, int n) {
        // write code here
        int[] bucket = new int [n];//桶
        int[] count =new int[10];//为入桶做辅助作用

        int max=A[0];
        for(int i =0;i<n;i++){//找到最大的数
            if(max<A[i])max=A[i];
        }

        int k=1;
        while((max=max/10)!=0){k++;}//计算最大值一共由几位十进制数组成，以从确定循环次数
        for(int i=1;i<=k;i++){
            for(int j=0;j<10;j++)count[j]=0;//初始化，避免上次循环的结果影响本次循环

            for(int j=0;j<n;j++){//计算
                count[getNum(A[j],i)]++;
            }
            for(int m=1;m<10;m++){//确定每个桶最右边的位置，以便在bucket数组中区分是哪个桶。
                count[m]=count[m]+count[m-1];
            }
            for(int j=n-1;j>=0;j--){//入桶
                int num = getNum(A[j],i);
                bucket[count[num]-1]=A[j];
                count[num]--;
            }

            for(int j=0;j<n;j++){//出桶
                A[j]=bucket[j];
            }
        }

        return A;
    }

    /**
     * 得到x的右数第d位的数是什么？
     * @param x
     * @param d
     * @return
     */
    private static int getNum(int x,int d){
        return ((x/(int)(Math.pow(10,d-1)))%10);
    }
}
