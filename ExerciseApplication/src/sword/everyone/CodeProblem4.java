package sword.everyone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Created by zhangzhiquan on 2018/3/7.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class CodeProblem4 {

    /**
     *Definition for binary tree
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || pre.length == 0){
            return null;
        }
        if(pre.length == 1){
            return new TreeNode(pre[0]);
        }
        int val = pre[0];
        TreeNode node = new TreeNode(val);
        int index = 0;
        for(int i = 0;i<in.length;i++){
            if(in[i] == val){
                index = i;
                break;
            }
        }
        node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,index+1)
                ,Arrays.copyOfRange(in,0,index));
        node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length),
                Arrays.copyOfRange(in,index+1,in.length));
        return node;
    }


    private void levelTraversal(TreeNode node){
        if(node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0;i<count;i++){
                TreeNode node1 = queue.poll();
                System.out.println(node1.val);
                if(node1.left != null){
                    queue.add(node1.left);
                }
                if(node1.right != null){
                    queue.add(node1.right);
                }
            }
        }
    }

    private void preTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        preTraversal(node.left);
        preTraversal(node.right);
    }

    public static void main(String[] args){
        CodeProblem4 obj = new CodeProblem4();
        TreeNode node = obj.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        obj.preTraversal(node);
    }

}
