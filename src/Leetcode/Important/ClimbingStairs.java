package Leetcode.Important;

/**
 *  70. 爬楼梯(斐波那契数列)Created by Ping on 2019/5/18.
 */
public class ClimbingStairs {
    //常规斐波那契数列递归，效率过低
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }

    //非递归斐波那契数列实现
    public int climbStairs2(int n){
        if (n <= 1) return 1;
        if (n == 2) return 2;

        int n1 = 1;
        int n2 = 2;

        for (int i = 3; i <= n; i++) {
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    //dp实现
    public int climbStairs3(int n){
        if (n <= 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //斐波那契公式直接得到，空间复杂度o(1)
    public int climbStairs4(int n) {
        double sqrt5 = Math.sqrt(5);    //根号5
        double Stairs = Math.pow((1 + sqrt5)/2,n + 1) - Math.pow((1 - sqrt5)/2,n + 1);

        return (int)(Stairs / sqrt5);
    }

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs4(5));
    }
}
