package two.two_12_paixu3;

import java.util.*;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/622:36
 */
public class two_13_ScaleSort {
    /*
        已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
        并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。

        给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。

        测试样例：
        [2,1,4,3,6,5,8,7,10,9],10,2
        返回：[1,2,3,4,5,6,7,8,9,10]
     */

    /**
     * 主体函数
     * @param A
     * @param n
     * @param k
     * @return
     */
    public int[] sortElement(int[] A, int n, int k) {
        // write code here
        int[] heap =getHeap(A,k);//辅助堆，初始化位A[0]-A[k-1]组成的堆

        //循环完毕A[0]-A[n-k-1]都放好了元素
        for (int i = k; i < n; i++) {
            A[i - k] = heap[0];//依次将堆顶放入数组，
            heap[0] = A[i];//将新元素放入堆中
            heapAdjust(heap, 0, k);//调整堆，将新放入的元素找到相应的位置
        }
        for (int i = n - k; i < n; i++) {
            A[i] = heap[0];
            swap(heap, 0, k - 1);//踢出最后一个元素还是堆，相当于将最后的元素作为新元素重新建堆
            heapAdjust(heap, 0, --k);
        }
        return A;
    }
    //从一个数组中建立堆  和heapInsert配合
    public int[] getHeap(int A[],int k){
        int[] heap = new int[k];
        for(int i=0;i<k;i++){
            heapInsert(heap,A[i],i);
        }
        return heap;
    }
    public void heapInsert(int[] heap,int value,int index){  //堆的插入操作
        heap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] > heap[index]) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    //堆调整
    public void heapAdjust(int[] A, int index, int k) {
        int left=index*2+1;
        int right=left+1;
        int smallest=index;
        while(left<k) {
            if(left<k&&A[left]<A[smallest])smallest=left;
            if(right<k&&A[right]<A[smallest])smallest=right;
            if(A[index]<=A[smallest]){break;}
            swap(A,index,smallest);
            index=smallest;
            left=index*2+1;
            right=left+1;
        }
    }
    public void swap(int[]A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }


    /**
     * 方法2  推荐：大话数据结构中的建堆和调整堆顶的方法
     */
    public int[] sortElement1(int[] A, int n, int k){
        // write code here
        int[] heap = getHeap1(A,k); //将A的前k位变成最小堆
        //循环完毕A[0]-A[n-k-1]都放好了元素


        for (int i = k; i < n; i++) {
            A[i - k] = heap[0];//依次将堆顶放入数组，
            heap[0] = A[i];//将新元素放入堆中
            heapAdjust(heap, 0, k-1);//调整堆，将新放入的元素找到相应的位置
        }
//循环完毕A[0]-A[n-k-1]都排序完毕，并且A[n-k]-A[n-1]也是小根堆
        for(int i=n-k;i<n;i++){
            A[i]=heap[0];
            swap(heap,0,k-1);

            heapAdjust(heap,0,--k-1);
        }

        return A;
    }
    public int[] getHeap1(int[] A, int k){
        int[] result = new int[k];
        for(int i = k/2-1;i>=0;i--){
            heapAdjust1(A,i,k-1);
        }
        for(int i =0;i<k;i++){
            result[i] = A[i];
        }
        return result;
    }
    public void heapAdjust1(int[] A,int low,int high){  //调整小根堆
        int temp,j;
        temp = A[low];
        for(j=2*low+1;j<=high;j=j*2+1){
            if(j<high&&A[j]>A[j+1]){//找到左右子树更小的一个
                j++;
            }
            if(temp<=A[j]){
                break;
            }
            A[low]=A[j];
            low=j;  //将左右子树较小的一个复制到父节点，并且记录这个子树的坐标
        }
        A[low]=temp;
    }

}
