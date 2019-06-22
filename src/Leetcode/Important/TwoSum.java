package Leetcode.Important;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {2, 7, 11, 15};
        twoSum.twoSum(arr, 9);
    }
}
