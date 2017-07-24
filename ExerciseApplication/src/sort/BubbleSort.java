package sort;


/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public class BubbleSort extends BaseSort implements ISort {
    @Override
    public void sort(int[] nums) {
        for(int i=0;i<nums.length;i++){
            boolean swap = false;
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    swap = true;
                    swap(nums,j,j+1);
                }
            }
            if(!swap){
                break;
            }
        }
    }
}
