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
}
