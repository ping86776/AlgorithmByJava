package Others;

public class BinarySearch {
    /**
     * 二分查找普通版
     * @param arr
     * @param target
     * @return
     */
    public static boolean binarysearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (target > arr[mid]) {
                low = mid + 1;
            }else if (target < arr[mid]) {
                high = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(BinarySearch.binarysearch(arr, 8));
    }
}
