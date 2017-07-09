package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangzhiquan on 2017/7/9.
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * https://www.nowcoder.com/practice/e08819cfdeb34985a8de9c4e6562e724?tpId=46&tqId=29030&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class SolutionMinDeep {

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int run(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return run(root.right) + 1;
        if(root.right == null)
            return run(root.left) + 1;
        return Math.min(run(root.left),run(root.right))+1;

    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int run2(TreeNode root) {
        if(root == null)
            return 0;
        int step = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            step++;
            for(int i=0 ;i<len;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    return step;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return 0;

    }


    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);

        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node3.right = node5;
        SolutionMinDeep solution = new SolutionMinDeep();
        System.out.println(solution.run(node));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}