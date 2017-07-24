package sort;

/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public class SelectionSort extends BaseSort implements ISort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            int minPos = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minPos] > nums[j]) {
                    minPos = j;
                }
            }
            swap(nums, i, minPos);
        }
    }
}
