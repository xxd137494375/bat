package three;

import org.junit.Test;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/2314:50
 */

public class StringTest {

    @Test
    public void test1(){
        char[] chs = {'A','B','C','D'};
        System.out.println(String.valueOf(1));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(chs,2,2));
    }

    @Test
    public void test2(){
        String s = "0123456";
        System.out.println(s.substring(6,7));
    }

    @Test
    public void test3(){
        String s1 = "ABC";
        String s2 = "ABD".replaceAll("D","C");
        System.out.println(s2.equals(s1));
        System.out.println(s1==s2);
    }
}
