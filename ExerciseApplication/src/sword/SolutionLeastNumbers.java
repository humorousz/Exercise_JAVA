package sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhangzhiquan on 2017/6/4.
 */

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class SolutionLeastNumbers {

    public static void main(String[] args){
        SolutionLeastNumbers solution = new SolutionLeastNumbers();
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = solution.GetLeastNumbers_Solution(input,4);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(12);

        for(int i=0;i<k;i++){
            createHeap(input);
            list.add(input[0]);
            input[0] = input[input.length - 1];
            input = Arrays.copyOf(input,input.length - 1);
        }
        return  list;
    }

    public void createHeap(int[] input){
        int length = input.length;
        int begin = length / 2 -1;
        for(int i = begin ; i>=0 ; i--){
            makeHeap(input,i);
        }
    }

    private void makeHeap(int[] input,int pos) {
        int length = input.length;
        while (pos < length){
            int left = pos * 2 + 1;
            int right = pos * 2 + 2;
            if(left < length && input[left] < input[pos]){
                //如果小于右子树才交换
                if(right < length && input[left] < input[right]){
                    int temp = input[pos];
                    input[pos] = input[left];
                    input[left] = temp;
                    pos = left;
                }
            }
            if(right < length && input[right] < input[pos]){
                int temp = input[pos];
                input[pos] = input[right];
                input[right] = temp;
                pos = right;
            }
            if(pos != left && pos != right){
                break;
            }
        }
    }
}