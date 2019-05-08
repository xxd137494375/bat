package two.two_12_paixu3;

/**
 * @Author ��xingxiangdong
 * @Date :2019/5/722:05
 */
public class two_14_Checker {
    /*
        �ظ�ֵ�ж�
        �����һ����Ч�㷨���ж��������Ƿ����ظ�ֵ�����뱣֤����ռ临�Ӷ�ΪO(1)��

        ����һ��int����A�����Ĵ�Сn���뷵�����Ƿ����ظ�ֵ��
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
        for(int i=n/2;i>=0;i--){//��n/2���ε����ڵ㣬����heap����
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
