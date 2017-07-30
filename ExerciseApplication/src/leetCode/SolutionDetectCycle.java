package leetCode;

/**
 * Created by zhangzhiquan on 2017/7/30.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 Follow up:
 Can you solve it without using extra space?
 https://www.nowcoder.com/practice/6e630519bf86480296d0f1c868d425ad?tpId=46&tqId=29038&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class SolutionDetectCycle {


    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        if(head == head.next){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null)
            return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args){
        //-1,-7,7,-4,19,6,-9,-5,-2,-5
        ListNode node0 = new ListNode(-1);
        ListNode node1 = new ListNode(-7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(-4);
        ListNode node4 = new ListNode(19);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(-9);
        ListNode node7 = new ListNode(-5);
        ListNode node8 = new ListNode(-2);
        ListNode node9 = new ListNode(-5);
        node0.next= node0;
        node1.next= node2;
        node2.next= node3;
        node3.next= node4;
        node4.next= node5;
        node5.next= node6;
        node6.next= node7;
        node7.next= node8;
        node8.next= node9;
        node9.next= node8;
        SolutionDetectCycle solutionDetectCycle = new SolutionDetectCycle();
        System.out.println(solutionDetectCycle.detectCycle(node0).val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}