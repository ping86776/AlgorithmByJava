package Leetcode.Important;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 这个题目开头暗示了n的范围，所以可以加以利用，将元素转换成数组的索引并对应的将该处的元素乘以-1；
 * 若数组索引对应元素的位置本身就是负数，则表示已经对应过一次；在结果列表里增加该索引的正数就行；
 */
public class FindAllDuplicatesinArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (nums[Math.abs(n) - 1] > 0)
                nums[Math.abs(n) - 1] *= -1;
            else
                res.add(Math.abs(n));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1,7};
        List<Integer> res = FindAllDuplicatesinArray.findDuplicates(arr);
        System.out.println(res);
    }
}
