package Leetcode;

/**
 * 657. Robot Return to Origin
 */
public class Robot {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)){
                case 'U': y++; continue;
                case 'D': y--; continue;
                case 'R': x++; continue;
                case 'L': x--;
            }

        }
        if (x==0&&y==0){
            return true;
        }else return false;

    }

    public static void main(String[] args) {
        String str = "UL";
        Robot robot = new Robot();

        System.out.println(robot.judgeCircle(str));
    }
}
