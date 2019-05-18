package Leetcode.Important;

/**
 *  53. 最大子序和 Created by Ping on 2019/5/18.
 */
public class MaximumSubarray {
    //动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

        return max;
    }
    //大佬算法
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums){
            if (sum > 0){
                sum += num;
            }else {
                sum = num;  //这里如果和小于0则后面的子序列肯定不包含目前的子序列
            }
//            max = Math.max(max, sum);
            max = max > sum ? max: sum;
        }

        System.out.println(max);
        return max;

    }

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        m.maxSubArray2(nums);
    }
}
