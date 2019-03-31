package Leetcode;

/**
 * 657. Robot Return to Origin
 */
public class Robot {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        int n = moves.length()-1;
        while (n >= 0){
            switch (moves.charAt(n)){
                case 'U': y++; break;
                case 'D': y--; break;
                case 'R': x++; break;
                case 'L': x--; break;
            }
            n--;
        }
        if (x == 0&&y == 0){
            return true;
        }else return false;

    }

    public static void main(String[] args) {
        String str = "UD";
        Robot robot = new Robot();
        System.out.println(robot.judgeCircle(str));
    }
}
