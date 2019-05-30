package Leetcode;

/**
 * 171. Excel表列序号 Created by Ping on 2019/5/30.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        //此问题就是26进制转10进制
        int sum = 0;
        int count = s.length()-1; //阶数
        for(int i = 0; i < s.length(); i++){
            sum += ((int)s.charAt(i) - (int)'A' + 1) * (int)Math.pow(26,count);
            count--;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        e.titleToNumber("AB");
    }
}
