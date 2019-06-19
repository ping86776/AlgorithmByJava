package Leetcode;

import java.util.Arrays;

/**
 * 268. 缺失数字 Created by Ping on 2019/6/19.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (flag == nums[i]) {
                flag++;
            }else {
                System.out.println(flag);
                return flag;
            }
        }

        return flag;

    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int nums[] = {9,6,4,2,3,5,7,0,1};
        missingNumber.missingNumber(nums);
    }


}
