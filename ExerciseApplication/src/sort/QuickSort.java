package sort;

/**
 * Created by zhangzhiquan on 2017/7/24.
 */
public class QuickSort extends BaseSort implements ISort {
    @Override
    public void sort(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int left,int right){
        if(left >= right){
            return;
        }
        int mid = findMidPos(nums,left,right);
        quickSort(nums,left,mid);
        quickSort(nums,mid+1,right);

    }

    private int findMidPos(int[] nums,int left,int right){
        int start = left;
        int end = right;
        int p = nums[left];
        while(start < end){
            while (p <= nums[end] && start < end)
                end--;
            swap(nums,start,end);
            while (nums[start] <= p && start < end)
                start++;
            swap(nums,start,end);
        }
        return start;
    }
}
