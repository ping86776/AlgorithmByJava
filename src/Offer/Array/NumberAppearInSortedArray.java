package Offer.Array;


/**
 * 数字在排序数组中出现的次数
 * 由于是排序数组，用二分查找分别获取target数在数组中第一次出现和最后一次出现的索引，然后相减即可
 */
public class NumberAppearInSortedArray {

    public static int find(int [] arr, int target) {
        int low = 0, high = arr.length-1;
        int first = getFirstIndex(arr, target, low, high);
        int last = getLastIndex(arr, target, low, high);

        return last - first + 1;
    }
    public static int getFirstIndex(int [] arr, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                //如果当前的target之前的数还是target，说明第一个出现的数还在前面
                if (mid > 0 && arr[mid - 1] == target) {
                    high = mid - 1;
                } else
                    return mid;
            }

        }

        return -1;
    }

    public static int getLastIndex(int [] arr, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                //如果当前的target之后的数还是target，说明最后一个出现的数还在后面
                if (mid < arr.length-1 && arr[mid + 1] == target) {
                    low = mid + 1;
                } else
                    return mid;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,3};
        int val = NumberAppearInSortedArray.find(arr, 2);
        System.out.println(val);
    }
}
