package three.three_4_string2;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/2314:27
 */
public class three_6_Reverse {
    /*
        句子逆序

        对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。

        给定一个原字符串A和他的长度，请返回逆序后的字符串。

        测试样例：
        "dog loves pig",13
        返回："pig loves dog"
     */
    public static String reverseSentence(String A, int n) {
        // write code here
        String[] s = A.split(" ");
        int len = s.length;
        String[] s1 =new String[len];
        int index=len-1;
        for(int i=0;i<len&&index>=0;i++){
            s1[index--]=s[i];
        }
        A="";
        for(int i=0;i<len-1;i++)A+=s1[i]+" ";
        A+=s1[len-1];
        return A;
    }

    public static String reverseSentence1(String A, int n) {
        // write code here
        A=reverse(A,0,n-1);
        int start =0;
        int end=0;
        for(int i=0;i<n&&start<n;i++){
            if(A.charAt(i)==' '){
                end=i-1;
                A=reverse(A,start,end);
                start=i+1;
            }
            if(i==n-1){
                A=reverse(A,start,n-1);
            }
        }
        return A;
    }
    public static String reverse(String str,int start,int end){
        char[] chs = str.substring(start,end+1).toCharArray();
        String res = "";
        int len=chs.length;
        for(int i=len-1;i>=0;i--){
            res+=chs[i];
        }
        return str.substring(0,start)+res+str.substring(end+1);
    }

//------------------------------------------------------------------------
// ------------------------------------------------------------------------
    /**
     * 参考答案  把String转换为字符数组
     * @param A
     * @param n
     * @return
     */
    public String reverseSentence3(String A, int n) {
        if (A == null || n == 0) {
            return A;
        }
        char[] s = A.toCharArray();
        rotateWord(s);
        return String.valueOf(s);
    }

    public void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; i++) {
            //当为' '略过两个if
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chas, l, r);
                l = -1;
                r = -1;
                }
            }
    }

    /**
     * 字符数组的反转操作 不需要额外的空间
     * @param chas
     * @param start
     * @param end
     */
    public void reverse(char[] chas, int start, int end) {
        char tmp = 0;
        while (start < end) {
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }
//------------------------------------------------------------------------
// ------------------------------------------------------------------------




    public static void main(String[] args) {
        String s = "TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB";
        String s1="0123456";
//        System.out.println(reverse(s1,1,4));
        System.out.println(reverseSentence1(s,47));
    }
}
