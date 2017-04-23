package sword;

import java.util.List;

/**
 * Created by zhangzhiquan on 2017/4/23.
 */
public class MainTest {
    public static void main(String[] args){
        SolutionPermutation solutionPermutation = new SolutionPermutation();
        List<String> res = solutionPermutation.Permutation("aaa");
        for(String str : res){
            System.out.println(str);
        }
    }
}
