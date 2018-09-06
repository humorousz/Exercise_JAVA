package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangzhiquan on 2018/3/13.
 */
public class PrintTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args){
        PrintTree obj = new PrintTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node6;
        node6.left = node7;
        node6.right = node8;
        System.out.print(obj.deep(node1));
    }



    public void lastPrint(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.left == null){
                continue;
            }
            stack.push(node);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null ){
                stack.push(node.left);
            }

            node.left = null;
            node.right = null;

        }
    }

    public void firstPrint(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null ){
                stack.push(node.left);
            }
            node.left = null;
            node.right = null;

        }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null ){
                stack.push(node.left);
            }
        }
        return res;
    }


    public int deep(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(deep(node.left),deep(node.right))+1;
    }
}
