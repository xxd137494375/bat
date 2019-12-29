package five.five_10_linkedlist3;

import five.ListNode;

/**
 * 无环链表相交问题
 * <p>
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * <p>
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/2922:58
 */
public class five_13_CheckIntersect {
    /**
     * self 只要两个链表相交，则两个链表自相交点开始往后结点均一样。 时间复杂度为O（n+m） 空间复杂度为O（1）
     *
     * @param headA
     * @param headB
     * @return
     */
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        // write code here
        while (headA != null && headA.next != null) {
            headA = headA.next;
        }
        while (headB != null && headB.next != null) {
            headB = headB.next;
        }
        return headA == headB ? true : false;
    }

    /**
     * 方法二：用哈希表，先遍历第一个链表，在遍历第二个链表，若发现有个结点在hash表中有记录，则这个结点就是第一个相交点
     */
    /**
     * 方法三：先求出两个链表的长度，假设n1 = 100,n2=50，则长的链表从第51个结点开始，短的链表从头开始，一起进行遍历，发现相同的结点即为相交点
     */
}
