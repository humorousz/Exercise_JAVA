package sword;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhangzhiquan on 2017/9/3.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class SolutionPrintMinNumber {


    public static void main(String[] args){
        int[] nums=new int[]{3,321,32};
        SolutionPrintMinNumber solutionPrintMinNumber = new SolutionPrintMinNumber();
        String s = solutionPrintMinNumber.PrintMinNumber(nums);
        System.out.print(s);
    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>(numbers.length);
        for(int i = 0 ; i < numbers.length ; i++){
            list.add(numbers[i]);
        }

        Collections.sort(list,(o1,o2)->{
            /*
            eg: 3,32
                332 > 323 -> o1 > o2
             */
            StringBuilder sb1 = new StringBuilder();
            sb1.append(o1).append(o2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(o2).append(o1);
            return sb1.toString().compareTo(sb2.toString());
        });
        StringBuilder res = new StringBuilder();
        for(Integer integer : list){
            res.append(integer);
        }
        return res.toString();
    }




}
