package sort;

/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public abstract class BaseSort {
    protected void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
