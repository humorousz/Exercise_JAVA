package sword;

/**
 * Created by zhangzhiquan on 2017/7/2.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 */
public class SolutionNumberOf1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for(int i = 1;i<=n;i++){
            sum += find1InN(i);
        }
        return sum;
    }


    public int find1InN(int n){
        int count = 0;
        while(n != 0){
            if(n % 10 == 1){
                count ++;
            }
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args){
        SolutionNumberOf1 solutionNumberOf1 = new SolutionNumberOf1();
        System.out.println(solutionNumberOf1.NumberOf1Between1AndN_Solution(100));
    }
}
