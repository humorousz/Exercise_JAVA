package chapter.five.reflection;

import java.util.ArrayList;

/**
 * Created by zhangzhiquan on 2017/4/30.
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args){
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i=1;i<6;i++){
            squares.add(i*i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
        System.out.println(new ObjectAnalyzer().toString(new ReflectioinTest()));
    }
}
