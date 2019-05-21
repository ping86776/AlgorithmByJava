package Leetcode.Important;


/**
 * 169. 求众数 Created by Ping on 2019/4/29.
 */
public class MajorityElement {
    //摩尔投票算法
    public int majorityElement(int[] nums) {
        int value = 0, count = 0;
        //定义一个状态值和计数器
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                value = nums[i];
                count = 1;
            }else if (value == nums[i]){
                count++;
            }else count--;
        }
        return value;
    }

        //排序找中位数不推荐
    //        Arrays.sort(nums);
//        int ret = nums[nums.length/2];


    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] arr = new int[]{2,2,2,1,1,2,2,2,2,2};
        System.out.println(m.majorityElement(arr));
    }
}
