package sword;

/**
 * Created by zhangzhiquan on 2018/3/13.
 */
public class PrintList {
    public static class ListNode{
        public ListNode(int v){
            val = v;
        }
        int val;
        ListNode next;
    }


    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode tail = node;
        for (int i = 2; i <= 5; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        PrintList obj = new PrintList();
        obj.printList(node);
        obj.printList(obj.f(node));
    }


    private void printList(ListNode node){
        while (node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }



    ListNode f(ListNode node){
        if(node == null){
            return null;
        }
        if(node.next == null){
            return node;
        }
        ListNode head,tail,newHead;
        head = node;
        tail = head.next;
        newHead = null;
        while (tail !=null){
            head.next = newHead;
            newHead = head;
            head = tail;
            tail = tail.next;
        }
        head.next = newHead;
        newHead = head;
        return newHead;
    }
}
