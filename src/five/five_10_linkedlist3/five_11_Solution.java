package five.five_10_linkedlist3;

/**
 * 复杂链表复制问题
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/2822:38
 */
public class five_11_Solution {


    /**
     * 不会做，只能看答案
     *
     * @param pHead
     * @return
     */
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode list = pHead;
        //第一遍遍历结点，每遍历到一个结点，复制一个相同的结点，并加入到当前结点的下一个位置；
        while (list != null) {
            RandomListNode node = new RandomListNode(list.label);
            node.next = list.next;
            list.next = node;
            list = list.next.next;
        }
        //第二遍遍历结点，设置新结点的random指针
        list = pHead;
        while (list != null) {
            if (list.random != null) {
                list.next.random = list.random.next;
            } else {
                list.next.random = null;
            }
            list = list.next.next;
        }
        list = pHead;
        RandomListNode newList = null;
        RandomListNode temp = null;
        RandomListNode res = null;
        //第三遍遍历结点，还原原来链表，取出所有的新结点；
        while (list != null) {

            list.next = list.next.next;
            list = list.next;
            temp = list.next;
            temp.next = null;

            if (newList == null) {
                newList = temp;
                res = temp;
            } else {
                newList.next = temp;
                newList = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;
        RandomListNode res = Clone(node1);
        System.out.println(res);
    }


    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
