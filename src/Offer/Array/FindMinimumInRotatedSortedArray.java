package Offer.Array;

/**
 * 寻找旋转排序数组中的最小值
 * 思路：二分查找，找到变化点，如下次测试用例的1,变化点小于左侧大于右侧
 * 如果中间元素 > 数组第一个元素，我们需要在 mid 右边搜索变化点。
 * 如果中间元素 < 数组第一个元素，我们需要在 mid 左边搜索变化点。
 * nums[mid] > nums[mid + 1]，因此 mid+1 是最小值。
 * nums[mid - 1] > nums[mid]，因此 mid 是最小值。
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int low = 0, high = nums.length-1;

        if (nums[high] > nums[low]) return nums[0];

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] > nums[0]) {
                low = mid + 1;
            }else
                high = mid - 1;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
        }
        return -1;
    }

    //这个方法就是如果当前节点比下一个节点大，下一个节点就是最小值，效率没有二分查找高
    public static int findMin2 (int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];


        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1])
                return nums[i+1];
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,1,2};
        int val = FindMinimumInRotatedSortedArray.findMin(arr);
        System.out.println(val);
    }
}
