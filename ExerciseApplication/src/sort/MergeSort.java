package sort;

/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public class MergeSort extends BaseSort implements ISort {
    @Override
    public void sort(int[] nums) {
        merge(nums,0,nums.length-1);
    }

    private void merge(int[] nums,int left,int right){
        if(left >= right)
            return;
        int mid = (left + right)/2;
        merge(nums,left,mid);
        merge(nums,mid+1,right);
        int startl = left;
        int startr = mid+1;
        int[] tmp = new int[right - left+1];
        int pos  = 0;
        while (startl <= mid && startr <= right){
            if(nums[startl] < nums[startr]){
                tmp[pos++] = nums[startl];
                startl ++;
            }else {
                tmp[pos++] = nums[startr];
                startr ++;
            }
        }
        while (startl <= mid){
            tmp[pos++] = nums[startl];
            startl++;
        }
        while (startr <= right){
            tmp[pos++] = nums[startr];
            startr++;
        }
        for (int k = 0;k<tmp.length;k++){
            nums[k+left]=tmp[k];
        }
    }
}
