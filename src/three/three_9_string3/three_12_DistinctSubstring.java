package three.three_9_string3;

import java.util.HashMap;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/248:41
 */
public class three_12_DistinctSubstring {
    /*
        最长无重复子串问题

        对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。

        给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。

        测试样例：
        "aabcb",5
        返回：3
     */
    public static int longestSubstring(String A, int n) {
        if(n==0||A==null)return 0;
        if(n==1)return 1;
        int pre = 1;
        int index=-1;
        int max=1;
        int curmax=1;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(A.charAt(0),0);
        for(int i=1;i<n;i++){
            if(map.get(A.charAt(i))!=null){
                index=map.put(A.charAt(i),i);//找到第i个字符上次出现的位置
            }else {
                index=-1;
                map.put(A.charAt(i),i);
            }
            int B = i-pre;//找到以i-1为尾部的无重复子串的第1个字符的位置。
            if(B>index){
                curmax=pre+1;//pre+1=i-B+1
            }else if (B<=index){
                curmax=i-index;
                System.out.println("--");
            }
            pre=curmax;//
            max=(curmax>max?curmax:max);
        }
        return max;
    }

    /**
     * 标准答案
     * @param A
     * @param n
     * @retur
     */
    public static int longestSubstring1(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        char[] chas = A.toCharArray();
        int[] map = new int[256];//当作hash表
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("kojypxtmcheuvhq",15));
    }
}
