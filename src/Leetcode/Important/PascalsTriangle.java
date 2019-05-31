package Leetcode.Important;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角 Created by Ping on 2019/5/31.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (numRows == 0) return result;
        res.add(1);
        result.add(res);
        res = new ArrayList<>();
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0||j == i){
                    res.add(1);
                }else {
                    //找规律，中间的索引为j的数都是上一个数组索引为j和j-1的两数之和
                    res.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
                }
            }
            result.add(res);
            res = new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        System.out.println(p.generate(1));
    }
}
