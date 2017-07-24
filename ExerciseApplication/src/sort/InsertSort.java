package sort;

/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public class InsertSort extends BaseSort implements ISort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j - 1 >= 0) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
                }
                j--;
            }
        }
    }
}
