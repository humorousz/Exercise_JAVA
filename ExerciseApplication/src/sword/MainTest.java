package sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangzhiquan on 2017/4/23.
 */
public class MainTest {
    public static void main(String[] args){
        testPermutation();
        testMoreThanHalfNum();
        testGetLeastNum();
        testThread();
    }

    private static void testPermutation(){
        SolutionPermutation solutionPermutation = new SolutionPermutation();
        List<String> res = solutionPermutation.Permutation("aaa");
        for(String str : res){
            System.out.println(str);
        }
    }

    private static void testMoreThanHalfNum(){
        SolutionMoreThanHalfNum solution = new SolutionMoreThanHalfNum();
        int[] num = new int[]{1,2,3,2,4,2,5,2,3};
        int ans = solution.MoreThanHalfNum_Solution(num);
    }

    private static void testGetLeastNum(){
        SolutionLeastNumbers solution = new SolutionLeastNumbers();
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = solution.GetLeastNumbers_Solution(input,4);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void testThread(){
        Object lock = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while (true) {
                        synchronized (lock) {
                            lock.notify();
                            lock.wait();
                            System.out.println("2");
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        System.out.println("1");
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


        threadA.start();
        threadB.start();

    }
}
