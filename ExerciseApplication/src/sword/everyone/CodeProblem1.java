package sword.everyone;

/**
 * @author Created by zhangzhiquan on 2018/3/6.
 * 剑指 offer 第一题
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class CodeProblem1 {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0){
            return false;
        }
        //从右上角开始寻找
        int c = array[0].length-1;
        int r = 0;
        while (r < array.length && c >= 0){
            if(target == array[r][c]){
                return true;
            }
            if(target > array[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }


    public static void main(String[] args){
        CodeProblem1 obj = new CodeProblem1();
        int [][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(obj.Find(7,array));
    }


}
