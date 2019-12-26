/**
 * @Author ??xingxiangdong
 * @Date :2019/5/817:31
 */
public class Test {
    public static void main(String[] args) {
        int [] A = {8,12,14,17,26,27,28,35,36,48,44,54};

        //[54,44,48,28,36,44,26,8,17,14,35,12,27,]
        for(int i=1;i<A.length;i++){
            heapInsert(A,i);
        }System.out.print("[");
        for(int i :A){

            System.out.print(i+",");

        } System.out.print("]");

//       [54,48,44,35,36,27,28,17,12,26,14,8,]
//        for(int i = (A.length-1)/2;i>=0;i--){
//            heap(A,i,A.length-1);
//        }System.out.print("[");
//                for(int i :A){
//
//            System.out.print(i+",");
//
//        } System.out.print("]");
    }

    public static void heap(int[]A,int low,int high){//???????????¦Ë  ???î”????¡À??????¡À?
        int temp = A[low];
        for(int s=low*2;s <= high;s*=2){
            if(s<high&&A[s]<A[s+1])s++;
            if(temp>A[s])break;
            A[low]=A[s];
            low=s;//??????????????????????
        }
        A[low]=temp;
    }

    public static void heapInsert(int[] arr, int index) {  //??????? 2
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
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
