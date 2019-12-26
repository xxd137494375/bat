package five.five_2_linkedlist2;

import five.ListNode;

/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 *
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 *
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 * @Author ：xingxiangdong
 * @Date :2019/12/2616:01
 */
public class five_5_Divide {
    /**
     * 自己做的,但是为什么说复杂度过高？
     * @param head
     * @param val
     * @return
     */
    public static ListNode listDivide(ListNode head, int val) {
        // write code here  {1,4,2,5},3
        ListNode smalltail = head;
        ListNode bigtail = head;
        ListNode smallhead = head;
        ListNode bighead = head;
        ListNode cur = head;
        ListNode next = cur.next;
        boolean flag1 =true;
        boolean flag2 =true;
        while(cur.next!=null){
            if(cur.val<=val ){
                if(flag1){
                    smallhead = cur;
                    smalltail = smallhead;
                    smalltail.next = null;
                    flag1 = false;
                }else{
                    smalltail.next = cur;
                    smalltail = smalltail.next;
                    smalltail.next=null;
                }
            }else{
                if(flag2){
                    bighead= cur;
                    bigtail = bighead;
                    bigtail.next = null;
                    flag2 = false;

                }else{
                    bigtail.next = cur;
                    bigtail = bigtail.next;
                    bigtail.next = null;
                }
            }
            cur = next;
            next = cur.next;
        }
        if(cur.val<=val){
            smalltail.next = cur;
            cur.next = bighead;
        }else {
            bigtail.next = cur;
            cur.next = null;
            smalltail.next = bighead;
        }
        return smallhead;
    }
    public static ListNode listDivide2(ListNode head, int val) {
        // write code here
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;
        ListNode next = null;
        while(head!=null){
            next=head.next;
            head.next=null;
            if(head.val<=val){
                if(smallHead==null){
                    smallHead=head;
                    smallTail=head;
                }else{
                    smallTail.next=head;
                    smallTail=smallTail.next;
                }
            }else{
                if(bigHead==null){
                    bigHead=head;
                    bigTail=head;
                }else{
                    bigTail.next=head;
                    bigTail=bigTail.next;
                }
            }
            head=next;
        }
        if(smallHead!=null){
            smallTail.next=bigHead;
        }
        return smallHead!=null?smallHead:bigHead;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        long cur = System.nanoTime();
        ListNode root = listDivide(node1,1);
        System.out.println(System.nanoTime()-cur);
        long cur1 = System.nanoTime();
        ListNode root1 = listDivide2(node1,1);
        System.out.println(System.nanoTime()-cur1);


        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }
        while(root1!=null){
            System.out.println(root1.val);
            root1=root1.next;
        }

    }
}
