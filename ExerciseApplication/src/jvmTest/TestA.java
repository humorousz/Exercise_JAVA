package jvmTest;

/**
 * Created by zhangzhiquan on 2017/12/12.
 */
public class TestA {
    public static int a = 1;
    void f(){
        a++;
        if(a <= 80){
            f();
        }
    }

    public static void main(String[] args){
        TestA a = new TestA();
        System.out.println(a.a());
    }

    int a(){
        int x;
        try {
            x = 1;
            System.out.println("nomal");
            return x;
        }catch (Exception e){
            x = 2;
            return x;
        }finally {
            x = 3;
            System.out.println("finally");
//            return x;
        }
    }
}
