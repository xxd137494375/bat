package three.three_9_string3;

/**
 * @Author ：xingxiangdong
 * @Date :2019/5/246:18
 */
public class three_10_Replacement {
    /*
        空格替换问题

        请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。

        给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。

        测试样例：
        "Mr John Smith”,13
        返回："Mr%20John%20Smith"
        ”Hello  World”,12
        返回：”Hello%20%20World”
     */

    /**
     * 库函数 一句话
     * @param iniString
     * @param length
     * @return
     */
    public String replaceSpace(String iniString, int length) {
        return iniString.replaceAll(" ","%20");
    }

    /**
     *
     * @param iniString
     * @param length
     * @return
     */
    public String replaceSpace1(String iniString, int length) {
        int count = 0;
        char[] inichs = iniString.toCharArray();//也可以用 charAt()函数不用额外数组
        for(int i=0;i<length;i++){
            if(inichs[i]==' ')count++;
        }
        int size = length + count*2;
        char[] chs = new char[size];
        int index=size-1;
        for(int i=length-1;i>=0;i--){
            if(inichs[i]!=' '){
                chs[index--]=inichs[i];
            }
            else{
                chs[index--]='0';
                chs[index--]='2';
                chs[index--]='%';
            }
        }
        return String.valueOf(chs);
    }

    /**
     * 通用
     * @param iniString
     * @param olds
     * @param news
     * @return
     */
    public static String replace(String iniString,char olds,String news){
        int length = iniString.length();
        System.out.println("len"+length);
        int count = 0;
        char[] inichs = iniString.toCharArray();//也可以用 charAt()函数
        for(int i=0;i<length;i++){
            if(inichs[i]==olds)count++;
        }
        System.out.println("count:  "+count);
        int lenofnews = news.length();
        int size = length +  count*(lenofnews-1 );
        char[] chs = new char[size];
        int index=size-1;

        char[] newchs = news.toCharArray();

        for(int i=length-1;i>=0;i--){
            if(inichs[i]!=olds){
               chs[index--] = inichs[i];
            }
            else{
                for(int j=newchs.length-1;j>=0;j--){
                    chs[index--] = newchs[j];
                }
            }
        }
        return String.valueOf(chs);
    }


    public static void main(String[] args) {
//        System.out.println("sArcCNxjNaviToUsSN QiTtx j bgUhhIoiSfszja QfFkxk JwYOoFSg dhdMKgTxjRrcATfkb ELqIebLGZk kAESkrNJxbmci nyojZqX vawG kxvqf moWAA m aMuilydRRNvVuh Uss mJtnZb zA oF cx hUQD V dSLSLcbjXLydl V dReEozdi ZO IxbW CgcTeobRrmco ELs cQh K xlg Pj cGaO yXKXy hs kmJaSdNV Z InShcp AxoM hHLTsIMhcHKnArxgRVjh MclqtzFpl yzaWlhLfYlfxNFgb".length());
        String res = replace("sArcCNxjNaviToUsSN QiTtx j bgUhhIoiSfszja QfFkxk JwYOoFSg dhdMKgTxjRrcATfkb ELqIebLGZk kAESkrNJxbmci nyojZqX vawG kxvqf moWAA m aMuilydRRNvVuh Uss mJtnZb zA oF cx hUQD V dSLSLcbjXLydl V dReEozdi ZO IxbW CgcTeobRrmco ELs cQh K xlg Pj cGaO yXKXy hs kmJaSdNV Z InShcp AxoM hHLTsIMhcHKnArxgRVjh MclqtzFpl yzaWlhLfYlfxNFgb",' ',"%20");
        String r = "sArcCNxjNaviToUsSN QiTtx j bgUhhIoiSfszja QfFkxk JwYOoFSg dhdMKgTxjRrcATfkb ELqIebLGZk kAESkrNJxbmci nyojZqX vawG kxvqf moWAA m aMuilydRRNvVuh Uss mJtnZb zA oF cx hUQD V dSLSLcbjXLydl V dReEozdi ZO IxbW CgcTeobRrmco ELs cQh K xlg Pj cGaO yXKXy hs kmJaSdNV Z InShcp AxoM hHLTsIMhcHKnArxgRVjh MclqtzFpl yzaWlhLfYlfxNFgb".replaceAll(" ","%20");
        System.out.println(res);
        System.out.println(r);
        System.out.println(res.length());
        System.out.println(r.length());
        System.out.println(res.equals(r));
        System.out.println(r.equals(res));
    }
}
