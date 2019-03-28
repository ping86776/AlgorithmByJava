package Leetcode;

/**
 * 149. Max Points on a Line Created by Ping on 2019/3/8.
 */


/**
 * 给定2D平面上的n个点，找到位于同一直线上的最大点数。
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class MaxPoints {
        public int maxPoints(Point[] points) {
        int max = 0,count;
        int a, b, c;
        int i;
        //小于两个点的情况
        if(points.length < 2) return points.length;
        //点重合的情况
        for(i=1; i<points.length; i++) {
            if(points[0].x!=points[i].x || points[0].y!=points[i].y) break;
        }
        //判断所有点是不是都重合
        if(i== points.length)    return points.length;
        //不重合的点判断是否是一条直线
        for(i = 0; i < points.length-1; i++) {
            for(int j = i+1; j < points.length; j++) {
                if(points[i].x != points[j].x || points[i].y != points[j].y) {
                    count=0;
                    a = points[j].y - points[i].y;
                    b = points[i].x - points[j].x;
                    c = -a * points[i].x - b * points[i].y;
                    for(int k = 0; k < points.length; k++) {
                        if(a * points[k].x + b*points[k].y + c == 0)	count++;
                    }
                    if(max < count)	max = count;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Point p3 = new Point(1,-1);
        Point[] points = new Point[3];
        points[0]=p1;
        points[1]=p2;
        points[2]=p3;
        MaxPoints solution = new MaxPoints();
        System.out.println(solution.maxPoints(points));
    }
}
