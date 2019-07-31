package Offer.Array;

/**
 * 二维数组中的查找
 * 二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。
 * 因此从右上角开始查找，
 *
 * 当要查找数字比右上角数字大时，下移；
 * 当要查找数字比右上角数字小时，左移；
 * 如果出了边界，则说明二维数组中不存在该整数。
 */
public class TwoDimArraySearch {
    public static boolean findTwoDim(int target, int [][] arr) {
        if (arr.length == 0 || arr[0].length == 0) return false;
        int row = arr[0].length-1;    //行索引
        int col = 0;    //列索引

        while (row >= 0 && col <= arr.length - 1){
            if (arr[row][col] > target) {
                row--;
            }else if (arr[row][col] < target) {
                col++;
            }else
                return true;
        }


        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(TwoDimArraySearch.findTwoDim(16,arr));
    }
}
