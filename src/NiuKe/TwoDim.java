package NiuKe;

/**
 * Created by Ping on 2019/3/20.
 */

/**
 * 二维数组的查找：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class TwoDim {
    public static boolean Find (int[][] arr, int n){
        int row = 0;    //行索引
        int col = arr[0].length-1;    //列索引
        while (row<=arr.length-1&&col>=0){
            if (n==arr[row][col]){
                return true;
            }else if (n<arr[row][col]){     //n比当前位置小，则一定在其左边
                col--;
            }else if (n>arr[row][col]){     //n比当前位置大，则一定在其下边
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(TwoDim.Find(arr, 7));

    }
}
