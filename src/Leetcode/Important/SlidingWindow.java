package Leetcode.Important;

/**
 * 给定一组大小为n的整数数组，计算长度为k的子数组和的最大值。
 */
public class SlidingWindow {
    //循环遍历
    public static int findKthMaxSumInArray(int[] arr, int k) {
        int maxSum = 0;// 记录最大子数组和，目前是从左开始第1个子数组
        for (int i = 0; i < k; i++) maxSum += arr[i];

        for (int i = 1; i <= arr.length - k; i++) {// 遍历所有子数组，求和并比较
            int curSum = 0;
            for (int j = 0; j < k; j++) {   // 计算当前子数组和(每次都要遍历计算k个数的和)
                curSum += arr[i + j];
            }
            if (curSum > maxSum) {// 如果大于最大和，则记录
                maxSum = curSum;
            }
        }
        return maxSum;

    }

    //滑动窗口
    public static int slidingWindow(int[] arr, int k) {
        int maxSum = 0;// 记录最大子数组和，目前是从左开始第1个子数组
        for (int i = 0; i < k; i++)  maxSum += arr[i];

        int curWindowSum = maxSum;
        for (int i = 1; i <= arr.length - k; i++) {// 从下个元素开始，即窗口向右滑动
            curWindowSum = curWindowSum - arr[i - 1] + arr[k + i - 1];// 减去失效值，加上最新值(不需要每次遍历计算k个数的和)
            if (curWindowSum > maxSum) {// 如果大于最大和，则记录
                maxSum = curWindowSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,4,7,-3,8,5,-2,6};
        int val = SlidingWindow.slidingWindow(arr,3);
        System.out.println(val);
    }
}
