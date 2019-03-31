package Leetcode;

/**
 * 476. Number Complement 补数是对该数的二进制表示取反
 */
public class NumberComplement {
    public int findComplement(int num) {
        int temp = num, a = 0;
        while (temp>0){
            temp >>= 1;
            a = (a<<1)+1;   //动态生成所有位都为1
        }
        return num^a;
    }

    public static void main(String[] args) {
        NumberComplement n = new NumberComplement();
        System.out.println(n.findComplement(4));
    }
}
