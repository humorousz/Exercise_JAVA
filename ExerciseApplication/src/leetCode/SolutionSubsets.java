package leetCode;

import java.util.*;

/**
 * @author zhangzhiquan
 * Given a set of distinct integers, S, return all possible subsets.
 */
public class SolutionSubsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(S);
        res.add(tmp);
        dfs(res,tmp,S,0);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() == o2.size()){
                    return 0;
                }
                if(o1.size() > o2.size()){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){
        for(int i=pos; i<=S.length-1;i++){
            tmp.add(S[i]);
            res.add(new ArrayList<Integer>(tmp));
            dfs(res,tmp,S,i+1);
            tmp.remove(tmp.size()-1);
        }
    }


    public void findSub(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int index){
        if(index == S.length){
            res.add(tmp);
            return;
        }
        findSub(res,new ArrayList<>(tmp),S,index+1);
        tmp.add(S[index]);
        findSub(res,new ArrayList<>(tmp),S,index+1);
    }





    public static void  main(String[] args){
        SolutionSubsets solutionSubsets = new SolutionSubsets();
        ArrayList<ArrayList<Integer>> subsets = solutionSubsets.subsets(new int[]{1,2,3,4});
        for(int i = 0;i<subsets.size();i++){
            for(int j = 0 ;j < subsets.get(i).size();j++){
                System.out.print(subsets.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
