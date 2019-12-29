package five.five_10_linkedlist3;

import five.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表判环问题
 * <p>
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * <p>
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/2921:48
 */
public class five_12_ChkLoop {
    /**
     * self初级解法： 对于是否有重复的且不考虑时间复杂度的场景，最直接的方法就是采用hash表 时间复杂度为O（n）空间复杂度为O（n）
     *
     * @param head
     * @param adjust
     * @return
     */
    public int chkLoop(ListNode head, int adjust) {
        // write code here
        int res = -1;
        Map<ListNode, Integer> hash = new HashMap<>();
        while (head != null) {
            if (hash.containsKey(head)) {
                return head.val;
            }
            hash.put(head, head.val);
            head = head.next;
        }
        return res;
    }

    /**
     * self高级解法，时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @param adjust
     * @return
     */
    public static int chkLoop1(ListNode head, int adjust) {
        if (head == null || head.next == null) {
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;

            } else {
                return -1;

            }
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return -1;

        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast.val;
    }
}
