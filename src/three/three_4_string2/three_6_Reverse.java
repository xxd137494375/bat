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

    /**
     * 方法一
     * @param A
     * @param n
     * @return
     */
    public static String reverseSentence(String A, int n) {
        // write code here
        String[] s = A.split(" ");
        String res = "";
        for(int i=s.length-1;i>=0;i--){
            res+=s[i];
            if(i==0) return res;
            res+=" ";
        }
        return res;
    }

    /**
     * 方法二
     * @param A
     * @param n
     * @return
     */
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

        }
        A=reverse(A,start,n-1);
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
     * 字符数组的反转操作
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
    public  String reverse5(String str,int start,int end){
        char[] strarr = str.toCharArray();
        int mid = (start+end)>>1;
        for(int i =0;i<=mid-start;i++){
            char temp = strarr[start+i];
            strarr[start+i] = strarr[end-i];
            strarr[end-i] = temp;
        }
        return new String(strarr);
    }
    public  String reverseSentence5(String A, int n) {
        // write code here
        System.out.println(A);
        A=reverse5(A,0,n-1);
        System.out.println(A);
        int start =0;
        for(int i=0;i<n&&start<n;i++){
            if(A.charAt(i)==' '){
                A=reverse5(A,start,i-1);
                System.out.println("i:"+i+"-start:"+start+":"+A);
                start=i+1;
            }
        }
        System.out.println(A);
        A = reverse5(A,start,n-1);
        System.out.println(A);
        return A;
    }


    public static void main(String[] args) {
        String s = "TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB";
        String s1="0123456";
//        System.out.println(reverse(s1,1,4));
//        System.out.println(reverseSentence1(s,47));
        three_6_Reverse t = new three_6_Reverse();
//        System.out.println(t.reverse5(s,0,2));
//        System.out.println(t.reverseSentence5(s,s.length()));
        t.reverseSentence5(s,s.length());
        System.out.println(t.reverse5("PTB GL PC LEWZIA DAJ TFWESBV NEBUJVK ILAIKM MUT", 4, 5));
    }
}
