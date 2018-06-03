package leetCode;


import java.util.*;

/**
 * Created by zhangzhiquan on 2018/6/3.
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
   Return all such possible sentences.
   For example, given
   s ="catsanddog",
   dict =["cat", "cats", "and", "sand", "dog"].
  A solution is["cats and dog", "cat sand dog"].
 https://www.nowcoder.com/practice/bd73f6b52fdc421d91b14f9c909f9104?tpId=46&tqId=29040&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class SolutionWordBreak2 {
    public static void main(String[] args){
        SolutionWordBreak2 obj = new SolutionWordBreak2();
        Set<String> set = new HashSet<>(16);
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        ArrayList list = obj.wordBreak("catsanddog",set);
        for(int i = 0 ;i < list.size();i++){
            System.out.println(list.get(i));
        }

    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String,ArrayList<String>> holder = new HashMap<>();
        return dfs(holder,s,dict);
    }

    private ArrayList<String> dfs(HashMap<String,ArrayList<String>> holder,String s,Set<String> dict){
        if(holder.containsKey(s)){
            return holder.get(s);
        }
        ArrayList<String> res = new ArrayList<>();
        if(s.equals("")){
            res.add(s);
        }else {
            int len = s.length();
            for(int i = 1;i<=len;i++){
                String sub = s.substring(0,i);
                if(dict.contains(sub)){
                    ArrayList<String> tmp = dfs(holder,s.substring(i,s.length()),dict);
                    if(tmp.size()== 0){
                        continue;
                    }else {
                        for(int k = 0; k < tmp.size();k++){
                            StringBuilder sb = new StringBuilder();
                            sb.append(sub).append(" ").append(tmp.get(k));
                            res.add(sb.toString().trim());
                        }
                    }
                }
            }
        }
        holder.put(s,res);
        return res;
    }

//
}
