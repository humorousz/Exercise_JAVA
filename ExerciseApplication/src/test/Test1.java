package test;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by zhangzhiquan on 2020/6/14.
 * 整数相加
 */
public class Test1 {

    public List<Integer> sumList(List<Integer> a, List<Integer> b) {
        List<Integer> result = new LinkedList<>();
        if (a == null && b == null) {
            return result;
        }
        if (a == null || a.size() == 0) {
            result.addAll(b);
            return result;
        }
        if (b == null || b.size() == 0) {
            result.addAll(a);
            return result;
        }
        int length = Math.max(a.size(), b.size());
        int jin = 0;
        int i;
        for (i = 0; i < length; i++) {
            int na = a.size() > i ? a.get(a.size() - 1 - i) : 0;
            int nb = b.size() > i ? b.get(b.size() - 1 - i) : 0;
            int sum = na + nb + jin;
            jin = sum >= 10 ? 1 : 0;
            sum -= jin * 10;
            result.add(0, sum);
        }
        if (jin >= 1) {
            result.add(0, 1);
        }
        return result;
    }

    public static void main(String args[]) {
        List<Integer> res = new Test1().sumList(Arrays.asList(9,9,9), Arrays.asList(1));
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }
}
