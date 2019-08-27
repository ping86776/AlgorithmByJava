package Leetcode;


import java.util.HashMap;

/**
 *  447. Number of Boomerangs Created by Ping on 2019/6/22.
 */
public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j){
                    double x =  points[i][0]-points[j][0];
                    double y =  points[i][1]-points[j][1];
                    double dis = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
                    System.out.println(dis);
                    if (!map.containsKey(dis)){
                        map.put(dis,1);
                    }else {
                        count += 2 * map.get(dis);//再一次出现相同距离就是An(m+1)
                        map.put(dis, map.get(dis) + 1);
                    }
                }
            }
            map = new HashMap<>();
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        NumberofBoomerangs numberofBoomerangs = new NumberofBoomerangs();
        numberofBoomerangs.numberOfBoomerangs(points);
    }
}
