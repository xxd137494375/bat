package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/912:29
 */
public class two_8_shellSort {
    /*
        希尔排序
     */
    public int[] shellSort(int[] A, int n) {
        // write code here
        if(n==0||n==1){
            return A;
        }
        int i,j;
        int s=n;
        while(s>1){
            s=s/3+1;//s即插入排序的间隔每次循环后减小
            for(i=s;i<n;i++){
                if(A[i]<A[i-s]){
                    int temp=A[i];
                    for(j=i-s;j>=0&&A[j]>temp;j-=s){ //这里是和temp即新插入的元素进行比较
                        A[j+s]=A[j];
                    }
                    A[j+s]=temp;
                }
            }

        }
        return A;
    }
}
