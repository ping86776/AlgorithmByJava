package Leetcode;

import java.util.Arrays;

/**
 *  283. 移动零 Created by Ping on 2019/5/30.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        //flag:插入位置下标 ; i:查找位置下标
        int flag = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[flag] = nums[i];
                flag++;
            }
        }
        //将后面的位置补0
        for(int j = flag; j < nums.length; j++){
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] nums = new int[]{0,2,1};
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
