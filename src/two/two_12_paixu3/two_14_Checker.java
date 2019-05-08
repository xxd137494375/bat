package two.two_12_paixu3;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/722:05
 */
public class two_14_Checker {
    /*
        重复值判断
        请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。

        给定一个int数组A及它的大小n，请返回它是否有重复值。
     */
    public boolean checkDuplicate(int[] a, int n) {
        // write code here
        boolean flag = false;
        a=heapSort(a,n);
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]){
                flag=true;
                break;
            }
        }
        return flag;
    }
    public int[] heapSort(int[] A, int n) {
        // write code here
        if(n==0||n==1){
            return A;
        }
        for(int i=n/2;i>=0;i--){//从n/2依次到根节点，进行heap调整
            heap(A,i,n-1);
        }
        for(int i=n-1;i>0;i--){
            swap(A,0,i);
            heap(A,0,i-1);
        }
        return A;
    }

    public void heap(int[]A,int low,int high){
        int temp = A[low];
        for(int s=low*2;s<=high;s*=2){
            if(s<high&&A[s]<A[s+1]){s++;}
            if(temp>=A[s])break;
            A[low]=A[s];
            low=s;
        }
        A[low]=temp;
    }

    public void swap(int[]A,int i,int j){
        int temp = A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
