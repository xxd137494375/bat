package five.five_2_linkedlist2;

import five.ListNode;

import java.util.Stack;

/**
 * 链表的回文结构
 * <p>
 * 请编写一个函数，检查链表是否为回文。
 * <p>
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * <p>
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/2715:56
 */
public class five_9_Palindrome {
    /**
     * self   第一种方法：空间复杂度 O(n)  时间复杂度O(n)  通俗易懂
     *
     * @param pHead
     * @return
     */
    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        Stack<Integer> s = new Stack<>();
        ListNode now = pHead;
        while (now != null) {
            s.push(now.val);
            now = now.next;
        }
        while (!s.isEmpty()) {
            if (s.pop() != pHead.val) {
                return false;
            }
            pHead = pHead.next;
        }
        return true;
    }

    /**
     * 第一种方法的改进法，空间复杂度变为了O(n/2)
     *
     * @param pHead
     * @return
     */
    public static boolean isPalindrome2(ListNode pHead) {
        // write code here
        Stack<Integer> s = new Stack<>();
        ListNode n1 = pHead;
        ListNode n2 = pHead;
        while (n2 != null) {
            s.push(n1.val);
            n1 = n1.next;
            //对于奇数个节点的链表 n2最后会停在最后一个节点，这样判断是为了避免空指针异常
            if (n2.next != null) {
                n2 = n2.next.next;
            } else {
                s.pop();
                break;
            }
        }
        while (n1 != null && !s.isEmpty()) {
            if (s.pop() != n1.val) {
                return false;
            }
            n1 = n1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(isPalindrome2(node1));


    }
}
