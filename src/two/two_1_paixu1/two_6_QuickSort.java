package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/11/2010:01
 */
public class two_6_QuickSort {
    public int[] quickSort(int[] A, int n) {
        // write code here
        if(A.length==0||A.length==1){
            return A;
        }
        sort(A,0,n-1);
        return A;
    }

    public void sort(int[] A,int left,int right){
//        if(left<right){
//            int pivot = partition1(A,left,right);
//            sort(A,left,pivot-1);
//            sort(A,pivot+1,right);
//        }

        while(left<right){  //尾递归
            int pivot = partition1(A,left,right);
            sort(A,left,pivot-1);
            left = pivot+1;
        }
    }
    public int partition(int[]A,int left,int right){
        System.out.println("------1.优化选数");
        int mid = (left+right)/2;//1.优化选数，尽可能选一个中庸的数字   把中间的数放到最右边
        if(A[right]>A[mid]){
            swap(A,right,mid);
        }
        if(A[mid]>A[left]){
            swap(A,mid,left);
        }
        if(A[right]<A[mid]){
            swap(A,right,mid);
        }
        System.out.println("---------------");

        int key=A[right];//选择最左边的
        int index =left;
        for(int i =left;i<right;i++){
            if(A[i]<key){
                swap(A,i,index);
                index++;
            }
        }
        swap(A,right,index);
        return index;
    }
    //[1,2,3,5,2,3]
    public int partition1(int[] A,int low,int high){
        int pivotkey ;
        pivotkey = A[low];
        System.out.println("pivotkey"+pivotkey);
        while(low<high){
            System.out.println(0);
            while(low<high&&A[high]>=pivotkey){  //加"="是为了避免有和pivotkey相同的数字
                high--;
                System.out.println(-1);
            }
            A[low] = A[high];
            while(low<high&&A[low]<=pivotkey){
                System.out.println(-2);
                low++;
            }
            A[high] = A[low];
        }
        A[low] = pivotkey;
        return low;
    }


    public void swap(int[] A,int num1,int num2){
        int temp = A[num1];
        A[num1] = A[num2];
        A[num2] = temp;
    }


    public static void main(String[] args) {
        int [] A= {1,2,4,5,2,6};
        two_6_QuickSort t = new two_6_QuickSort();
        t.quickSort(A,6);
        for(int num : A){
            System.out.println(num);
        }

    }

}
