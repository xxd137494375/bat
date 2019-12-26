/**
 * @Author ：xingxiangdong
 * @Date :2019/12/2119:40
 */

/**
 * 多线程
 */
public class test2 {
    int i ;
    final int j;
    static test2 obj;
    static int k;
    public test2(){
        i=1;
        j=2;
    }
    public static void writer(){
        obj = new test2();
    }
    public static void reader(){
        test2 object = obj;
        int a=object.i;
        int b = object.j;
        System.out.println(a);
        System.out.println(b);
    }



    public static void main(String[] args) {
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                test2.writer();
//            }
//        };
//        t1.start();
//        Thread t2 = new Thread(){
//            @Override
//            public void run() {
//                test2.reader();
//            }
//        };
//        t2.start();

    }



}
