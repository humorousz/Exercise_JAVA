package chapter.fourteen;

/**
 * Created by zhangzhiquan on 2017/7/8.
 */
public class syncTest {

    public static void main(String[] args){
        Thread thread1,thread2,thread3;
        A a = new A();
        thread1 = new Thread(()->{
            a.a();
        });

        thread2 = new Thread(()->{
           a.b();
        });

        thread3 = new Thread(()->{
            a.c();
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }


    /**
     * synchronized中使用this和A.class的区别是
     * 如果使用了this如果获取到锁后，所有非静态同步方法将无法调用
     * 如果使用了A.class获取到锁后，所有静态同步方法将无法调用
     */
    private static class A{
        public  void a(){
            synchronized (this){
                while (true){
                    System.out.println("fa");
                }
            }
        }

        synchronized public  void b(){
            while(true){
                System.out.println("fb");
            }
        }

        synchronized public static void c(){
            while (true){
                System.out.println("fc");
            }
        }
    }
}



