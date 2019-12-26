package three.three_1_string1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/2222:50
 */
public class three_3_Transform {
    /*
        词语变形

        对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。

        给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。

        测试样例：
        "abc",3,"bca",3
        返回：true
     */
    public boolean chkTransform(String str1, int lena, String str2, int lenb) {
        //特殊情况
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];//如果字符的种类很多，可以使用哈希表代替整型数组。
        for (int i = 0; i < chas1.length; i++) {//将每个字符对应ascii码位置上+1；
            map[chas1[i]]++;   //如果在需要输入int的地方  输入了字符性的话 会自动将这个字符变成ascii码中的数字
        }
        for (int i = 0; i < chas2.length; i++) {
            if (map[chas2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化解法，包括所以字符
     * @param str1
     * @param lena
     * @param str2
     * @param lenb
     * @return
     */
    public boolean chkTransform1(String str1, int lena, String str2, int lenb) {
        HashMap<Character,Integer> h = new HashMap<Character, Integer>();
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        for (int i = 0; i < chas1.length; i++) {//将每个字符对应ascii码位置上+1；
            if(h.get(chas1[i])!=null){
                int num = h.get(chas1[i]);
                h.put(chas1[i],++num);
            }else{
                h.put(chas1[i],1);
            }
        }
        for (int i = 0; i < chas2.length; i++) {
            if(h.get(chas2[i])==null)return false;
            if (h.get(chas2[i]) == 0) {
                return false;
            }else{
                int num = h.get(chas2[i]);
                h.put(chas2[i],--num);
            }
        }
        return true;
    }

    /**
     * 通过hash可以表示所有字符（例如中文等）
     * @param str1
     * @param lena
     * @param str2
     * @param lenb
     * @return
     */
    public boolean chkTransform2(String str1, int lena, String str2, int lenb) {
        Map h1 = new HashMap();
        for(char ch : str1.toCharArray()){
            if(h1.containsKey(ch)){
                int num = (int)h1.get(ch);
                h1.put(ch,++num);
            }else{
                h1.put(ch,1);
            }
        }
        for(char ch : str2.toCharArray()){
            if(h1.containsKey(ch)){
                int num =(int)h1.get(ch);
                if(num==0)return false;
                h1.put(ch,--num);
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char A = '中';
        System.out.println(A);
        HashMap h = new HashMap();
        h.put(1,1);
        Integer i =1;
        System.out.println(i++);
        System.out.println(h.get(1));
//        System.out.println(h.get(1));
//        System.out.println((int)'a');
//        int[] arr = new int[256];
//        arr['a'] = 1;
//        for(int i=0;i<arr.length;i++ ){
//            if(arr[i]==1){
//                System.out.println(i);
//            }
//        }
    }
}
