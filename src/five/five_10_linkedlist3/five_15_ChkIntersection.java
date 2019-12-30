package five.five_10_linkedlist3;

import five.ListNode;

/**
 * 单链表相交判断
 * <p>
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 * <p>
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/3017:22
 */
public class five_15_ChkIntersection {
    /**
     * self 是前面三道题的结合版。 通过12判断有无环并得到入环节点，  两个无环的用13题求解 两个有环的用14题求解  一个有环一个无环不可能相交
     * <p>
     * 时刻注意：只要两个单链表相交，则两个链表在相交点后的节点全部是一样的
     * 只要一个链表有环，
     *
     * @param head1
     * @param head2
     * @return
     */
    public boolean chkInter(ListNode head1, ListNode head2) {
        // write code here
        ListNode slow1 = head1;
        ListNode fast1 = head1;
        ListNode ringnode1 = null;
        ListNode slow2 = head2;
        ListNode fast2 = head2;
        ListNode ringnode2 = null;
        while (fast1 != null) {
            slow1 = slow1.next;
            fast1 = fast1.next;
            if (fast1 != null) {
                fast1 = fast1.next;
            }
            if (fast1 == slow1) {
                break;
            }
        }
        if (fast1 != null) {
            fast1 = head1;
            while (fast1 != slow1) {
                slow1 = slow1.next;
                fast1 = fast1.next;
            }
            ringnode1 = slow1;
        }

        while (fast2 != null) {
            slow2 = slow2.next;
            fast2 = fast2.next;
            if (fast2 != null) {
                fast2 = fast2.next;
            }
            if (slow2 == fast2) {
                break;
            }
        }
        if (fast2 != null) {
            fast2 = head2;
            while (fast2 != slow2) {
                slow2 = slow2.next;
                fast2 = fast2.next;
            }
            ringnode2 = slow2;
        }
        if (ringnode1 == null && ringnode2 == null) {
            //两个无环单链表判断相交
            return CheckIntersect(head1, head2);
        }
        if (ringnode1 != null && ringnode2 != null) {
            //两个有环单链表判断相交
            return CheckIntersectOfRing(head1, head2, ringnode1, ringnode2);
        }
        return false;

    }

    public boolean CheckIntersect(ListNode head1, ListNode head2) {
        while (head1.next != null) {
            head1 = head1.next;
        }
        while (head2.next != null) {
            head2 = head2.next;
        }
        return head1 == head2;
    }

    public boolean CheckIntersectOfRing(ListNode head1, ListNode head2, ListNode ringnode1, ListNode ringnode2) {
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
        }
        return false;
    }
}
