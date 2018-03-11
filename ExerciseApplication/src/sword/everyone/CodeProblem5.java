package sword.everyone;

import java.util.Stack;

/**
 * @author Created by zhangzhiquan on 2018/3/9.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class CodeProblem5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        CodeProblem5 obj = new CodeProblem5();

        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        for (int i = 0 ;i < 3;i++){
            System.out.println(obj.pop());
        }
        obj.push(6);
        obj.push(7);
        obj.push(8);
        obj.push(9);
        obj.push(10);

        for (int i = 0 ;i < 7;i++){
            System.out.println(obj.pop());
        }
    }
}
