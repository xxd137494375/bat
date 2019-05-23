package three.three_4_string2;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/245:40
 */
public class three_8_Prior {
    /*
        拼接最小字典序：

        对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。

        给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。

        测试样例：
        ["abc","de"],2
        "abcde"
     */
    public String findSmallest(String[] strs, int n) {
        // write code here
        if(n==0)return null;
        if(n==1)return strs[1];
        for(int i=1;i<n;i++){
          for(int j=i-1;j>=0;j--){
              String s1 = strs[j]+strs[j+1];
              String s2 = strs[j+1]+strs[j];
              if(s1.compareTo(s2)>0){
                    String temp = strs[j];
                    strs[j]=strs[j+1];
                    strs[j+1]=temp;
              }
          }
        }
        String res = "";
        for(int i=0;i<n;i++){
            res+=strs[i];
        }
        return res;
    }
}
