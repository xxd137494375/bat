package two.two_12_paixu3;

/**
 * @Author ��xingxiangdong
 * @Date :2019/5/813:31
 */
public class two_15_Merge {
    /*
        ��������ϲ���ϰ

        ��������С���������Ժ������A��B������A��ĩ�����㹻�Ļ��������B�����дһ����������B�ϲ���A������
        ������������int����A��B��A�еĻ������0��䣬ͬʱ����A��B����ʵ��Сint n��int m���뷵�غϲ�������顣
     */

    /**
     * very easy
     *
     * ע��㣺ֻҪB������ �Ϳ��Խ�����
     * @param A
     * @param B
     * @param n
     * @param m
     * @return
     */
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        // write code here
        int i=n-1;
        int j=m-1;
        int index=m+n-1;
        while(i>=0&&j>=0){
            if(A[i]>=B[j])A[index--]=A[i--];
            else A[index--]=B[j--];
        }
//        while(i>=0){
//            A[index--]=A[i--];  ��Ϊ����Ƿŵ�A�����������������һ��
//        }
        while(j>=0){
            A[index--]=B[j--];
        }
        return A;
    }


    /**
     * �𰸣�ʡ��3������
     */
    public int[] mergeAB1(int[] A, int[] B, int n, int m) {
        while (m != 0) {
            if (n == 0) {
                A[m - 1] = B[m - 1];
                m--;
            } else {
                A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
                //ͨ��һ��   A[m+n-1]=A[n-1]>B[m-1]?A[n-1]:B[m-1];  n--; m--
            }
        }
        return A;
    }
}
