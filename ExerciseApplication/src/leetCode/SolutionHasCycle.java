package leetCode;

/**
 * @author Created by zhangzhiquan on 2018/3/14.
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=46&tqId=29039&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class SolutionHasCycle {
    /**
     * Definition for singly-linked list.
     */
     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if(fast == p){
                return true;
            }
            p = p.next;
            fast = fast.next.next;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if(fast == p){
                break;
            }
            p = p.next;
            fast = fast.next.next;
        }
        if(fast ==null || fast.next ==null){
            return null;
        }
        p = head;
        while(p != fast){
            p = p.next;
            fast = fast.next;
        }
        return fast;

    }

    public static void main(String[] args){
        SolutionHasCycle obj = new SolutionHasCycle();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        System.out.println(obj.hasCycle(node));
    }
}
