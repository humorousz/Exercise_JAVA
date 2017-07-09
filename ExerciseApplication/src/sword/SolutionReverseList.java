package sword;

/**
 * Created by zhangzhiquan on 2017/7/9.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class SolutionReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList1(ListNode head) {
        ListNode newhead = null;
        ListNode nexthead ;
        while (head != null){
            nexthead = head.next;
            head.next = newhead;
            newhead = head;
            head = nexthead;
        }
        return newhead;
    }

    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newhead = null;
        ListNode nexthead = null;
        nexthead = head.next;
        newhead = ReverseList(nexthead);
        head.next = null;
        nexthead.next = head;
        return newhead;
    }
}


