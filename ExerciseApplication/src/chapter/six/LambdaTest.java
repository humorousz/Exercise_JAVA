package chapter.six;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by zzq on 17-6-1.
 */
public class LambdaTest {

    public static void main(String[] args){
        ss((a,b,c)->System.out.println("ssss"+a));
        String[] planets = new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by Length");
        Arrays.sort(planets,(first,second)->first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(100,(event->
                System.out.println("The time is "+ new Date())));
        t.start();
//        keep program running until user selects "OK"
        Thread thread = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(i);
            }
        });

        Thread thread1 = new Thread(System.out::println);
        thread1.start();
//        thread.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);



    }


    private static void ss(DD d){
        d.f(1,2,3);
    }


    interface DD{
        void f(int a,int b,int c);
    }
}
