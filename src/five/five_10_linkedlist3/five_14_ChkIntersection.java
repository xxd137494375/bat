package five.five_10_linkedlist3;

import five.ListNode;

/**
 * 有环单链表相交判断问题
 * <p>
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * <p>
 * 给定两个链表的头结点head1和head2。请返回一个bool值代表它们是否相交。
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/3010:40
 */
public class five_14_ChkIntersection {
    /**
     * self
     *
     * @param head1
     * @param head2
     * @return
     */
    public boolean chkInter(ListNode head1, ListNode head2) {
        // write code here
        ListNode slow1 = head1;
        ListNode fast1 = head1;
        ListNode slow2 = head2;
        ListNode fast2 = head2;
        ListNode ringnode1 = null;
        ListNode ringnode2 = null;
        //找到head1入环节点
        {
            while (fast1 != null) {
                slow1 = slow1.next;
                fast1 = fast1.next.next;
                if (slow1 == fast1) {
                    break;
                }
            }
            fast1 = head1;
            while (fast1 != slow1) {
                slow1 = slow1.next;
                fast1 = fast1.next;
            }
            ringnode1 = slow1;
        }
        //找到head2入环节点
        {
            while (fast2 != null) {
                slow2 = slow2.next;
                fast2 = fast2.next.next;
                if (slow2 == fast2) {
                    break;
                }
            }
            fast2 = head2;
            while (fast2 != slow2) {
                slow2 = slow2.next;
                fast2 = fast2.next;
            }
            ringnode2 = slow2;
        }
        //判断是否相交
        {
            if (ringnode1 == ringnode2) {
                return true;
            } else {
                ListNode temp = ringnode1.next;
                while (temp != ringnode1) {
                    if (temp == ringnode2) {
                        return true;
                    }
                    temp = temp.next;
                }
                return false;
            }
        }

    }
}
