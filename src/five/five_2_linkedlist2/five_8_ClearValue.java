package five.five_2_linkedlist2;

import five.ListNode;

/**
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 *
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 *
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 * @Author ：xingxiangdong
 * @Date :2019/12/2712:07
 */
public class five_8_ClearValue {
    /**
     * 自己第一次做的，循环遍历链表删除指定值，分头节点，中间节点，尾节点进行处理，其实可以合并
     * @param head
     * @param val
     * @return
     */
    public ListNode clear(ListNode head, int val) {
        // write code here
        ListNode res = head;
        while(res!=null&&res.val == val){
            ListNode cur = res;
            res = res.next;
            cur.next = null;
        }
        ListNode pre = res;
        ListNode root =res;
        if(res==null||res.next==null){
            return res;
        }else{
            res = res.next;
        }
        while(res!=null&&res.next!=null){
            if(res.val ==val){
                pre.next = res.next;
                res.next =null;
                res = pre.next;
            }else{
                pre = res;
                res = res.next;
            }
        }

        if(res.val == val){
            pre.next = null;
        }
        return root;
    }

    /**
     * 自己想法的改进版，
     * @param head
     * @param val
     * @return
     */
    public ListNode clear2(ListNode head, int val) {
        // write code here
        if(head == null)
            return null;

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        ListNode rootpre = pre;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }

        }
        return rootpre.next;
    }
    /**
     * 视频中的思想：构构建新的链表
     * @param head
     * @param val
     * @return
     */
    public ListNode clear1(ListNode head, int val) {
        // write code here
        ListNode root = null ;
        ListNode tail = null ;
        while(head!=null){
            if(head.val!=val){
                if(root==null){
                    root = new ListNode(head.val);
                    tail = root;
                }else {
                    tail.next =new  ListNode(head.val);
                    tail = tail.next;
                }
            }
            head = head.next;
        }
        return root;
    }
}
