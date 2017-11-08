package sword;

/**
 * Created by zhangzhiquan on 2017/7/9.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class SolutionReverseList {

    public static class ListNode {
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

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return ;
        ListNode tHead = head;
        ListNode fast = head.next;
        ListNode nomal = head;
        while(fast != null && fast.next != null){
            nomal = nomal.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = nomal.next;
        nomal.next = null;
        right = ReverseList(right);
        ListNode newHead = new ListNode(1);
        ListNode tail = newHead;
        while(left != null && right != null){
            ListNode tmpL = left.next;
            ListNode tmpR = right.next;
            tail.next = left;
            tail = left;
            tail.next = right;
            tail = right;
            left = tmpL;
            right = tmpR;
        }

        if(left != null)
            tail.next = left;
        if(right != null)
            tail.next = right;
        tHead = newHead.next;

    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        SolutionReverseList su = new SolutionReverseList();
        su.reorderList(node);
        System.out.println(su);

    }

}


