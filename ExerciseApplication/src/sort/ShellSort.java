package sort;

/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public class ShellSort extends BaseSort implements ISort {
    @Override
    public void sort(int[] nums) {
        for (int gaps = nums.length / 2; gaps > 0; gaps /= 2) {
            for (int i = 0; i < gaps; i++) {
                for (int j = i + gaps; j < nums.length; j += gaps) {
                    int k = j;
                    while (k-gaps >=0){
                        if(nums[k] < nums[k-gaps]){
                            swap(nums,k,k-gaps);
                        }else {
                            break;
                        }
                        k-=gaps;
                    }
                }
            }
        }
    }
}
