package sword.everyone;

/**
 * @author Created by zhangzhiquan on 2018/3/6.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class CodeProblem2 {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0){
            return "";
        }
        int spaceCount = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == ' '){
                spaceCount++;
            }
        }
        if(spaceCount == 0){
            return str.toString();
        }
        int oldEnd = str.length() - 1;
        int newEnd = oldEnd + spaceCount * 2;
        str.setLength(newEnd + 1);
        while (oldEnd >= 0 && oldEnd < newEnd){
            if(str.charAt(oldEnd) == ' '){
                str.setCharAt(newEnd--,'0');
                str.setCharAt(newEnd--,'2');
                str.setCharAt(newEnd--,'%');
            }else {
                str.setCharAt(newEnd--,str.charAt(oldEnd));
            }
            oldEnd --;
        }
        return str.toString();
    }

    public static void main(String[] args){
        CodeProblem2 obj = new CodeProblem2();
        StringBuffer sb = new StringBuffer(30);
        sb.append("We Are Happy");
        System.out.println(obj.replaceSpace(sb));
    }
}
