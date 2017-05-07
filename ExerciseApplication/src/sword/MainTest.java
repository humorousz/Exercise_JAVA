package sword;

import java.util.List;

/**
 * Created by zhangzhiquan on 2017/4/23.
 */
public class MainTest {
    public static void main(String[] args){
        testPermutation();
        testMoreThanHalfNum();

    }

    private static void testPermutation(){
        SolutionPermutation solutionPermutation = new SolutionPermutation();
        List<String> res = solutionPermutation.Permutation("aaa");
        for(String str : res){
            System.out.println(str);
        }
    }

    private static void testMoreThanHalfNum(){
        SolutionMoreThanHalfNum solution = new SolutionMoreThanHalfNum();
        int[] num = new int[]{1,2,3,2,4,2,5,2,3};
        int ans = solution.MoreThanHalfNum_Solution(num);
    }
}
