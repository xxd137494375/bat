package two.two_1_paixu1;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/722:14
 */
public class two_7_HeapSort {
    /*
        堆排序

        对于一个int数组，请编写一个堆排序算法，对数组元素排序。

        给定一个int数组A及数组的大小n，请返回排序后的数组。

        测试样例：[1,2,3,5,2,3],6
                 [1,2,2,3,3,5]
     */

    /**
     * 注意点 ：  两种初始堆生成方法。 1.一个一个加进去满足条件 ，从上至下 2.有一个完整的数组，从最后一个叶子结点的父结点都后面开始进行堆调整  ，从下至上
     * @param A
     * @param n
     * @return
     */


    public int[] heapSort(int[] A, int n) {
        // write code here
        if(n==0||n==1){
            return A;
        }
        for(int i=n/2-1;i>=0;i--){//从n-1/2依次到根节点，进行heap调整,只要保证从最后一个叶子结点处的后面开始即可。
            heap(A,i,n-1);
        }
        for(int i=n-1;i>0;i--){
            swap(A,0,i);
            heap(A,0,i-1);
        }
        return A;
    }
    public void heap(int[]A,int low,int high){//调正堆，参数位  数组、开始下标、结束下标。
        int temp = A[low];
        for(int s=low*2+1;s<=high;s=2*s+1){//对于没有哨兵的左孩子是index*2+1
            if(s<high&&A[s]<A[s+1])s++;
            if(temp>=A[s])break;
            A[low]=A[s];
            low=s;//这样做是为了减少交换的开销
        }
        A[low]=temp;
    }


    /**
     * 第二种方法：
     * @param A
     */
    public  int[] heapSort1(int[] A, int n) {
        for (int i = 0; i != n; i++) {
            heapInsert(A, i);
        }
        for (int i = A.length - 1; i != 0; i--) {
            swap(A, 0, i);
            heapify(A, 0, i);
        }
        return A;
    }

    public  void heapInsert(int[] arr, int index) {  //初始化堆 2
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
    //这个不如上面的那个多了2个变量，且用了交换
    public  void heapify(int[] arr, int index, int heapSize) {//堆化   数组、开始指引、堆的大小  high=index+heapSize-1
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {//有左子树
            if (arr[left] > arr[index]) {//左子树大于
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
