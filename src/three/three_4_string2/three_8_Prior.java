package three.three_4_string2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 要合理利用JAVA的接口函数,提高熟练度
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

    /**
     * 方法一:自己编写排序的函数
     * @param strs
     * @param n
     * @return
     */
    public String findSmallest(String[] strs, int n) {
        // write code here
        if(n==0)return null;
        if(n==1)return strs[1];
        for(int i=1;i<n;i++){
          for(int j=i-1;j>=0;j--){
              //***********************************************
              String s1 = strs[j]+strs[j+1];
              String s2 = strs[j+1]+strs[j];
              if(s1.compareTo(s2)>0){   //************* 这是重点,重新定义排序规则.而不是简单地比较数组两个不同位置的字典序
                    String temp = strs[j];
                    strs[j]=strs[j+1];
                    strs[j+1]=temp;
              }
              //***********************************************

          }
        }
        String res = "";
        for(int i=0;i<n;i++){
            res+=strs[i];
        }
        return res;
    }


    /**
     * 方法二:不自己写排序函数,通过java的接口进行编写,可以看出一个人的java熟练度
     * @param strs
     * @param n
     * @return
     */
    public String findSmallest2(String[] strs, int n) {

        if(strs == null || strs.length <= 0){
            return null;
        }
        //***********************************************
        Arrays.sort(strs,new Comparator<String>(){

            public int compare(String s1, String s2){
                String a = s1+s2;
                String b = s2+s1;
                return a.compareTo(b);
            }

        });
        //***********************************************

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            sb.append(strs[i]);
        }
        return sb.toString();

    }




}
