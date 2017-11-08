package leetCode;

/**
 * Created by zzq on 17-7-20.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root.left== null && root.right == null){
            res.add(root.val);
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null){
                res.add(node.val);
                continue;
            }
            TreeNode node2 = new TreeNode(node.val);
            stack.push(node2);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;

    }
}