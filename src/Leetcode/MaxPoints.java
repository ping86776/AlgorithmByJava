package Leetcode;

/**
 * 149. Max Points on a Line Created by Ping on 2019/3/8.
 */


/**
 * ����2Dƽ���ϵ�n���㣬�ҵ�λ��ͬһֱ���ϵ���������
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
        //С������������
        if(points.length < 2) return points.length;
        //���غϵ����
        for(i=1; i<points.length; i++) {
            if(points[0].x!=points[i].x || points[0].y!=points[i].y) break;
        }
        //�ж����е��ǲ��Ƕ��غ�
        if(i== points.length)    return points.length;
        //���غϵĵ��ж��Ƿ���һ��ֱ��
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
