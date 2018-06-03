package sword;

/**
 * Created by zhangzhiquan on 2018/6/3.
 *
 */
public class SolutionFirstNotRepeatingChar {
    public static void main(String[] args){
        SolutionFirstNotRepeatingChar obj = new SolutionFirstNotRepeatingChar();
        System.out.println(obj.FirstNotRepeatingChar("google"));
    }


    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        if(str.length() == 1){
            return 0;
        }
        int[] bigger = new int[26];
        int[] biggerPos = new int[26];
        int[] small = new int[26];
        int[] smallPos = new int[26];

        char[] list = str.toCharArray();
        for(int i = list.length-1 ;i >=0;i--){
            if(list[i]>='A' && list[i]<='Z'){
                bigger[list[i]-'A']++;
                biggerPos[list[i]-'A'] = i;
            }else {
                small[list[i]-'a']++;
                smallPos[list[i]-'a'] = i;
            }
        }

        int min = list.length;
        for (int i = 0; i < bigger.length; i++) {
            if (bigger[i] == 1) {
                min = biggerPos[i] < min ? biggerPos[i] : min;
            }
        }

        for (int i = 0; i < small.length; i++) {
            if (small[i] == 1) {
                min = smallPos[i] < min ? smallPos[i] : min;
            }
        }

        return min;
    }
}
