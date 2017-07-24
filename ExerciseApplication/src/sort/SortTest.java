package sort;

/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public class SortTest {
    private final static int  MAX = 100;
    public static void main(String[] args){
        int[] nums = new int[MAX];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int) (Math.random()*100);
        }
        ISort iSort = new ShellSort();
        iSort.sort(nums);
        for (int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
