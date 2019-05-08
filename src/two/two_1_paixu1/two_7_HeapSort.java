package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/722:14
 */
public class two_7_HeapSort {

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
            if(s<high&&A[s]<A[s+1])s++;
            if(temp>=A[s])break;
            A[low]=A[s];
            low=s;
        }
        A[low]=temp;
    }


    /**
     * 第二种方法：
     * @param arr
     */
    public  void heapSort(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int i = arr.length - 1; i != 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public  void heapInsert(int[] arr, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public  void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public  void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
