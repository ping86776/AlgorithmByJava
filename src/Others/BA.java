package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Ping on 2019/4/16.
 */
public class BA {
    private double[][] V; 		// Velocities (N x D)   速度
    private double[] Q; 		// Frequency : 0 to Q_MAX (N x 1)   频率
    private double[] F;			// Fitness (N)
    private double R = 0.5; 			// Pulse Rate : 0 to 1  脉冲概率
    private double A = 1; 			// Louadness : A_MIN to A_MAX 响度
    private double lo;		// Lower bound (1 x D)
    private double up;		// Upper bound (1 x D)
    private double fmin; 		// Minimum fitness from F
    private double[] B;			// Best solution array from X (D)

    private final int N; 		// Number of bats
    private final int MAX = 1; 		// Number of iterations
    private final double Q_MIN = 0.0;
    private final double Q_MAX = 2.0;
    private final double A_MIN = 0.0;
    private final double A_MAX = 1.0;
    private final double R_MIN = 0.0;
    private final double R_MAX = 1.0;

    private final int D ;  // dim
    private final Random rand = new Random();

    private List<double[]> pop ; //输入的解集
    private List<Double> mipslist ;
    private List<Integer> lengthlist ;

    public BA(int N, int D, double up, double lo, List<double[]> pop, List<Double> mipslist, List<Integer> lengthlist){
        // Initialize Variable
        this.N = N;
        this.D = D;
        this.pop = pop;
        this.mipslist = mipslist;
        this.lengthlist = lengthlist;

        this.up = up;
        this.lo = lo;

        this.V = new double[N][D];
        this.Q = new double[N];
        this.F = new double[N];


        for ( int i = 0; i < N; i++ ){
            for ( int j = 0; j < D; j++ ) {
                this.V[i][j] = 0.0;
            }
        }

    }
    public BA(int N, int D, double up, double lo, List<double[]> pop){
        // Initialize Variable
        this.N = N;
        this.D = D;
        this.pop = pop;

        this.up = up;
        this.lo = lo;

        this.V = new double[N][D];
        this.Q = new double[N];
        this.F = new double[N];


        for ( int i = 0; i < N; i++ ){
            for ( int j = 0; j < D; j++ ) {
                this.V[i][j] = 0.0;
            }
        }

    }

    private double getFitness(double[] Xi){
        int N = Xi.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Xi[i];
        }
        return sum;
    }

    //获取平均值
    public double getAverage(double[] arr) {
        double sum = 0;
        int number = arr.length;
        for (int i = 0; i < number; i++) {
            sum += arr[i];
        }
        return sum / number;
    }

    //获取标准差
    public double getStandardDevition(double[] arr) {
        double sum = 0;
        int number = arr.length;
        double avgValue = getAverage(arr);//获取平均值
        for (int i = 0; i < number; i++) {
            sum += Math.pow((arr[i] - avgValue), 2);
        }

        return Math.sqrt((sum / (number - 1)));
    }

    private double[] SimpleBounds(double[] Xi) {
        double[] Xi_temp = new double[D];
        System.arraycopy(Xi, 0, Xi_temp, 0, D);
        for (int i = 0; i < D; ++i) {
            if (Xi_temp[i] < lo)
                Xi_temp[i]= lo;

            if (Xi_temp[i] > up)
                Xi_temp[i] = up;
        }
        return Xi_temp;
    }

    public double[] startBat(){

        for (int i = 0; i < pop.size(); i++) {
            F[i] = getFitness(pop.get(i));
        }
        /**
         * 计算初始最优解
         */
        int bestIndex = 0;
        for (int i = 1; i < pop.size(); i++) {
            if (F[i] < F[bestIndex]){
                bestIndex = i;
            }
        }
        double fmin = F[bestIndex]; //初始最优适应度
        B = pop.get(bestIndex); //初始最优解
//        System.out.println("the beginning solution is:"+Arrays.toString(best));

        double[] res_temp = new double[D];
        int n_iter = 0;
//        for ( int t = 0; t < n_iter; t++ ){
        while (n_iter!=5) {
            // Loop for all bats(N)
            for ( int i = 0; i < pop.size(); i++ ){
                // Update frequency (Nx1)
                Q[i] = Math.abs(Q_MIN + (Q_MAX-Q_MIN) * rand.nextDouble());
                // Update velocity (NxD)
                for ( int j = 0; j < D; j++ ){
                    V[i][j] = Math.abs(V[i][j] + (pop.get(i)[j] - B[j]) * Q[i]);
                }
                // Update S = X + V
                for ( int j = 0; j < D; j++ ){
                    //二维扰动
                    res_temp[j] = (1 - 0.1 * (Math.random() * 2 - 1)) * pop.get(i)[j] + (Math.random() * 2 - 1) * V[i][j];
//                    res_temp[j] = 0.9 * pop.get(i)[j] + 0.1* V[i][j];
//                    res_temp[j] = pop.get(i)[j] + V[i][j];
                }

                res_temp = SimpleBounds(res_temp);

                //可变步长
                double epsilon = 0.4/(1+Math.exp(0.015*(n_iter-50)/3));
                if ( Math.random() > R)
                    for ( int j = 0; j < D; j++ ) {
//                        res_temp[j] = B[j] + 0.001 * (Math.random()*2-1);
                        res_temp[j] = B[j] + epsilon * (Math.random()*2-1) ;
                    }
                // Apply bounds/limits
                res_temp = SimpleBounds(res_temp);
                // Evaluate new solutions
                double fnew = getFitness(res_temp);



                // Update if the solution improves or not too loud
                if (fnew <= F[i] && Math.random() < A){
                    for (int j = 0; j < D; j++) {
                        pop.get(i)[j] = res_temp[j];
                    }
                    F[i] = fnew;
//                    A = 0.9 * A;    //响度更新
//                    R = R * (1 - Math.exp(-1 * 0.9 * n_iter));  //频率更新

                }
                // Update the current best solution
                if ( fnew <= fmin ){
                    for (int j = 0; j < D; j++) {
                        B[j] = res_temp[j];
                    }
                    fmin = fnew;
                }
                B = SimpleBounds(B);
            } // end loop for N
            n_iter++;
        } // end loop for MAX

//        System.out.println("Number of evaluations : " + n_iter );
//        System.out.println("Best = " + record );
//        System.out.println("fmin = " + fmin );
        for (int i = 0; i < B.length; i++) {
            B[i] = (int)B[i];
        }
        return B;
    }
    public static void main(String[] args) {
        List<double[]> poplist = new ArrayList<>();
        Random rand = new Random();
        double[] r = new double[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                r[j] = Math.random() * 2 - 1;
            }
            poplist.add(r);
            r = new double[10];
        }
        double[] a = new double[]{7,7,7,7,7,7,7,7,7,7};
        poplist.add(a);
//        for (int i = 0; i < poplist.size(); i++) {
//            System.out.println(Arrays.toString(poplist.get(i)));
//        }

        BA ba = new BA(10,10,7,-1,poplist);
        double[] best = ba.startBat();
        System.out.println(Arrays.toString(best));


    }
}
