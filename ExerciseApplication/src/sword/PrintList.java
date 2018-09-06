package sword;

import java.awt.*;

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
        obj.printList(obj.nf2(node));
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

    ListNode nf(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode newHead = null;
        while (node != null){
            ListNode tmp = node;
            node = node.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    ListNode nf2(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode newHead = null;
        while (node != null){
            ListNode tmp = node.next;
            node.next = newHead;
            newHead = node;
            node = tmp;
        }
        return newHead;
    }

    ListNode df(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode fff = node.next;
        node.next = null;
        ListNode newHead = df(fff);
        ListNode tmp =newHead;
        while (tmp .next !=null){
            tmp= tmp.next;
        }
        tmp.next = node;
        return newHead;
    }


}
