package three.three_4_string2;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/244:08
 */
public class three_7_Translation {
    /*
        字符串移位

        对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。

        给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。

        测试样例：
        "ABCDE",5,3
        返回："DEABC"
     */
    //库函数：一行代码
    public String stringTranslation(String A, int n, int len) {
        // write code here
        return A.substring(len)+A.substring(0,len);
//        return (A+A).substring(len,len+n);
    }


    /**
     * 参考答案正规做法  (A-B-)- = BA
     * @param A
     * @param n
     * @param len
     * @return
     */
    public String stringTranslation1(String A, int n, int len) {
        // write code here
        char[] c =A.toCharArray();
        charTranslation(c,len,n);
        return String.valueOf(c);
    }
    public void charTranslation(char[] c,int len,int n){
        reverse(c,0,len-1);
        reverse(c,len,n-1);
        reverse(c,0,n-1);
    }
    public void reverse(char[] ch,int start,int end){
        while(start<end){
            char temp=ch[end];
            ch[end]=ch[start];
            ch[start]=temp;
            end--;
            start++;
        }
    }
}
