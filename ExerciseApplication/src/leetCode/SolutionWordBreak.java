package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by zhangzhiquan on 2018/3/14.
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 */


public class SolutionWordBreak {
//    public boolean wordBreak(String s, Set<String> dict) {
//        for(String dst:dict){
//            if(workBreak(s,dst)){
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || dict==null || dict.size()==0){
            return false;
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0;i <= s.length();i++){
            for(int j = 0;j < i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        for(int i =0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp[s.length()];
    }


    public static void main(String[] args){
        SolutionWordBreak obj = new SolutionWordBreak();
        Set<String> set = new HashSet<>(16);
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(obj.wordBreak("catsanddog",set));
    }
}
