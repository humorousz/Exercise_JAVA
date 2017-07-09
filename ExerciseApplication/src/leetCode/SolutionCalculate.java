package leetCode;

import java.util.Stack;

/**
 * Created by zhangzhiquan on 2017/7/9.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class SolutionCalculate {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(!isOpt(s)){
                stack.push(s);
            }else {
                String opt2 = stack.pop();
                String opt1 = stack.pop();
                String val = cal(s,opt1,opt2);
                stack.push(val);
            }
        }
        return Integer.valueOf(stack.pop()).intValue();
    }

    private boolean isOpt(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private String cal(String opt,String num1,String num2){
        Integer int1 = Integer.valueOf(num1);
        Integer int2 = Integer.valueOf(num2);
        if(opt.equals("+")){
            return String.valueOf(int1 + int2);
        }
        if(opt.equals("-")){
            return String.valueOf(int1 - int2);
        }
        if(opt.equals("*")){
            return String.valueOf(int1 * int2);
        }
        if(opt.equals("/")){
            return String.valueOf(int1 / int2);
        }
        return "";
    }

    public static void main(String[] args){
        String[] t1 = new String[]{"2", "1", "+", "3", "*"};
        String[] t2 = new String[]{"4", "13", "5", "/", "+"};
        SolutionCalculate solutionCalculate = new SolutionCalculate();
        System.out.println(solutionCalculate.evalRPN(t1));
        System.out.println(solutionCalculate.evalRPN(t2));
    }
}
