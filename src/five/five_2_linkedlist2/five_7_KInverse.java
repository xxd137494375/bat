package five.five_2_linkedlist2;

import five.ListNode;

import java.util.Stack;

/**
 * 链表的k逆序练习
 *
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 *
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 *
 * @Author ：xingxiangdong
 * @Date :2019/12/2713:51
 */
public class five_7_KInverse {
    /**
     * 第1次的答案
     * @param head
     * @param k
     * @return
     */
    public ListNode inverse(ListNode head, int k) {
        // write code here
        Stack<ListNode> s = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode cur = null;
        ListNode start = null;
        ListNode end = null;
        while(head!=null){
            cur = head;
            head = head.next;
            cur.next = null;
            s.push(cur);
            if(s.size()==k){
                while(!s.isEmpty()){
                    if(start ==null){
                        start = s.pop();
                        end = start;
                    }else{
                        end.next = s.pop();
                        end = end.next;
                    }
                }
            }
        }
        while(!s.isEmpty()){
            s2.push(s.pop());
        }
        while(!s2.isEmpty()){
            end.next = s2.pop();
            end = end.next;
        }
        return start;
    }
}
