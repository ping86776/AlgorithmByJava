package Offer.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 思路：确定上下左右四条边的位置，那么初始化的时候，上边up就是0，下边down就是row-1，左边left是0，右边right是col-1。
 * 然后进行while循环，先遍历上边，将所有元素加入结果res，然后上边下移一位，如果此时上边大于下边，说明此时已经遍历完成了，直接break。
 * 要注意单行和单列的情况。
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int row = matrix.length;    //行索引
        int col = matrix[0].length; //列索引

        int u = 0, d = row - 1, l = 0, r = col - 1;
        while (true) {
            //左->右
            for(int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            u++;
            if(u > d) break;

            //上->下
            for(int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            if(r < l) break;

            //右->左
            for(int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            d--;
            if(d < u) break;

            //下->上
            for(int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            if(l > r) break;

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> res = SpiralMatrix.spiralOrder(arr);
        System.out.println(res);
    }

}
