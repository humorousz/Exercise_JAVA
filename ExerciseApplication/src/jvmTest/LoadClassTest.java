package jvmTest;

/**
 * Created by zhangzhiquan on 2017/12/8.
 */
public class LoadClassTest {
    public static class Super{
//        public static int m = 11;
        static {
            System.out.println("I am Super");
        }

        public static class Father extends Super{
            public static int m = 22;
            static {
                System.out.println("I am Father");
            }
        }

        public static class Child extends Father{

            static {
                System.out.println("I am Child");
            }
        }


        public static void main(String[] args){
            System.out.println(Child.m);
        }
    }
}
