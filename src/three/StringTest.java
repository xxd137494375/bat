package three;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * StringBuffer类型学习
     */
    @Test
    public void sbtest(){
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        sb.append(1);
        sb.append(5);
        sb.append(6);
        System.out.println(sb.indexOf("1"));
        System.out.println(sb.lastIndexOf("1"));
        System.out.println(sb.lastIndexOf("5",3));
    }
    @Test
    public void maptest(){
        Map h1 = new HashMap();
        h1.put('a',1);
        h1.put('b',2);
        for(Object key:h1.keySet()){

        }
        System.out.println(h1.get('a'));

    }

    @Test
    public void sbtest1(){
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        sb.append(4);
//        sb.replace(1,2,"x");
        sb.setCharAt(1,'x');
        System.out.println(sb);
    }
}
