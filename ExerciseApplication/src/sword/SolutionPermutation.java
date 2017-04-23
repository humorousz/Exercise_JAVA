package sword;

/**
 * Created by zhangzhiquan on 2017/4/23.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class SolutionPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        HashSet<String> set = new HashSet<>();
        cal(set,str.toCharArray(),0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }


    public void cal(HashSet<String>list,char[] str,int pos){
        if(pos == str.length -1){
            list.add(new String(str));
            return;
        }
        for(int i=pos;i<str.length;i++){
            swap(str,i,pos);
            cal(list,str,pos+1);
            swap(str,i,pos);
        }
    }


    public void swap(char[] str,int x,int y){
        char tmp = str[x];
        str[x] = str[y];
        str[y] = tmp;
    }
}