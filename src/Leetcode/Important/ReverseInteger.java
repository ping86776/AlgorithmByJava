package Leetcode.Important;

/**
 *  7. Reverse Integer(这里有个越界问题)
 *  res 保存旧的翻转中间值, temp 保存新的翻转过程中间值
    依次提取 x 的末位加入 temp, 如果发生溢出则通过temp/10无法得到上一轮的翻转结果 res
 *  Created by Ping on 2019/4/28.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int temp = res * 10 + x % 10;
            if (temp / 10 != res){
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }
}
