package sword;

/**
 * Created by zhangzhiquan on 2017/6/18.
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class SolutionFindGreatestSum {
    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        SolutionFindGreatestSum solutionFindGreatestSum = new SolutionFindGreatestSum();
        System.out.println(solutionFindGreatestSum.findMax_2(array));
    }


    public int FindGreatestSumOfSubArray(int[] array) {
//        return findMax_1(array);
        return findMax_2(array);
    }

    /**
     * 暴力求解，o(n*n)
     * @param array
     * @return
     */
    public int findMax_1(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划，o(n)
     * 设sum[i]为以第i个元素结尾且和最大的连续子数组。
     * 假设对于元素i，所有以它前面的元素结尾的子数组的长度都已经求得，那么以第i个元素结尾且和最大的连续子数组实际上，
     * 要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是只包含第i个元素，即sum[i] = max(sum[i-1] + a[i], a[i])。
     * 可以通过判断sum[i-1] + a[i]是否大于a[i]来做选择，而这实际上等价于判断sum[i-1]是否大于0。由于每次运算只需要前一次的结果，
     * 因此并不需要像普通的动态规划那样保留之前所有的计算结果，只需要保留上一次的即可，因此算法的时间和空间复杂度都很小。
     * @param array
     * @return
     */
    public int findMax_2(int[] array) {
        int curSum = array[0];
        int max = curSum;
        for (int i = 1; i < array.length; i++) {
            if (curSum > 0) {
                curSum += array[i];
            } else {
                curSum = array[i];
            }
            max = max(max, curSum);
        }
        return max;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

}
