package sword.everyone;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Created by zhangzhiquan on 2018/3/6.
 *         输入一个链表，从尾到头打印链表每个节点的值。
 *         https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class CodeProblem3 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<>(1);
        }
        Stack<Integer> stack = new Stack<>();
        ListNode head = listNode;
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 递归解决
     * @param node
     * @param integers
     */
    private void revert(ListNode node,ArrayList<Integer> integers){
        if(node == null){
            return;
        }
        revert(node.next,integers);
        integers.add(node.val);
    }

    public static void main(String[] args){
        CodeProblem3 obj = new CodeProblem3();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(obj.printListFromTailToHead(node1));
    }
}
