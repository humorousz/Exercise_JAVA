package leetCode;

/**
 * Created by zzq on 17-7-12.
 * Sort a linked list in O(n log n) time using constant space complexity.
 * merge sort
 */
public class SolutionSortList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode nomal = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            nomal = nomal.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(nomal.next);
        nomal.next = null;
        ListNode left = sortList(head);
        ListNode newHead = null;
        ListNode tail = null;
        while(right != null && left != null){
            if(right.val < left.val){
                if(newHead == null){
                    newHead = right;
                    tail = newHead;

                }else{
                    tail.next = right;
                    tail = tail.next;
                }
                right = right.next;
            }else{
                if(newHead == null){
                    newHead = left;
                    tail = newHead;
                }else{
                    tail.next = left;
                    tail = tail.next;
                }
                left = left.next;
            }
        }

        if(left != null){
            tail.next = left;
        }

        if(right != null){
            tail.next = right;
        }

        return newHead;
    }
}
