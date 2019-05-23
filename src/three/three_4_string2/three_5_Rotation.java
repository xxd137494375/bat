package three.three_4_string2;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/2314:22
 */
public class three_5_Rotation {
    /*
        两串旋转：

        如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。

        给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。

        测试样例：
        "cdab",4,"abcd",4
        返回：true
     */
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena!=lenb)return false;
        String AA= A+A;//穷举所有旋转词
        return AA.contains(B);
    }
}
