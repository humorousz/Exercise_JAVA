package sword;



import java.util.*;

/**
 * Created by zhangzhiquan on 2017/7/10.
 * 忘了写的啥了。。。。
 */
public class Solution {
    public static class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
//        Solution solution = new Solution();
//        solution.findParent(4,10);
//        B b = new B();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        List<String> list = sub(nums);
        Arrays.sort(list.toArray());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private void findParent(int x,int y){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left  = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        ArrayList<Integer> list = new ArrayList<>();
        findPath(node1,list,10);
        findPath(node1,list,6);

    }


    public static List<String> sub(int[] num){
        if(num == null || num.length ==0)
            return null;
        List<String> list = new LinkedList<>();

        for(int i=0;i<num.length;i++){
            for(int j = 0;j<num.length;j++){
                if(j+i < num.length){
                    StringBuilder builder = new StringBuilder();
                    builder.append(num[j]);
                    for(int k = 1 ; k <= i;k++){
                        if(j + k < num.length){
                            builder.append(" "+num[j+k]);
                        }else {
                            break;
                        }
                    }
                    list.add(builder.toString());
                }
            }
        }
        return list;
    }

    private ArrayList<Integer> findPath(TreeNode node , ArrayList<Integer> list,int target){
        if(node == null )return  null;
        if(node.val == target || node.left == null && node.right == null){
            if(node.val == target){
                list.add(target);
                return list;
            }
            return null;
        }

        if(findPath(node.left,list,target) != null){
            list.add(node.val);
            return list;
        }

        if(findPath(node.right,list,target)!= null){
            list.add(node.val);
            return  list;
        }

        return  null;
    }

    static class A {
        private int a= 1;
        public int getA(){
            return a;
        }
    }
    static class B extends A{
        private int a = 2;

        public int getVal(){
            return a;
        }
    }

}
