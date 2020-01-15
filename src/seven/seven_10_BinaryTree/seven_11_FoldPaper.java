package seven.seven_10_BinaryTree;

import java.util.ArrayList;

/**
 * 折纸练习题
 * <p>
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 * <p>
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 * <p>
 * 测试样例：
 * 1
 * 返回：["down"]
 *
 * @Author ：xingxiangdong
 * @Date :2020/1/1523:40
 */
public class seven_11_FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        fold(1, n, true, list);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void fold(int i, int N, boolean down, ArrayList<String> ret) {
        if (i > N) {
            return;
        }
        fold(i + 1, N, true, ret);
        ret.add(down ? "down" : "up");
        fold(i + 1, N, false, ret);
    }
}
