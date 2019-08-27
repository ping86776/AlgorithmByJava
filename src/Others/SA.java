package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *  模拟退火算法 Created by Ping on 2019/5/19.
 */
public class SA {
    private double T = 10000.0; //温度
    private double rate = 0.75; //冷却系数
    private int step = 1;   //状态步数

    private double[] F;    // Fitness (N)

    private final Random rand = new Random();

    private double up;
    private double lo;

    private List<double[]> pop ; //种群


    private int dim;    //维度
    private int popsize;    //种群数量

    private double[] best;
    private int bestindex = 0;

    private double R; //目标区域总面积

    public SA(int popsize, int dim, double up, double lo, List<double[]> pop, double R){
        this.popsize = popsize;
        this.pop = pop;

        this.dim = dim;

        this.up = up;
        this.lo = lo;

        this.F = new double[popsize];

        this.R = R;
    }

    private double getFitness(double[] Xi){
        //先用两个代理区域计算
        double constraint2 = 0;
        double constraint5 = 0;
        if (Xi.length == 10) {
            constraint2 = Math.abs((Xi[0]*Xi[1])-(Xi[4]*Xi[5]))/(Xi[0]*Xi[1]);
            constraint5 = 1 - Math.pow(((Xi[2]*Xi[3]+Xi[6]*Xi[7])/R)/0.4, 2);
        }

        return constraint2 * 0.8 + constraint5 * 0.2;
    }

    public double[] runSA(){
        List<double[]> newpop = new ArrayList<>();
        newpop.addAll(pop);

        while (T > 0.1){
            for (int iter = 0; iter < 5; iter++) {
                int index = rand.nextInt(dim);
                int stepindex = rand.nextInt(step-(-step)+1)+(-step);
                if ((index != 2 && stepindex != 7)||(index != 7 && stepindex != 2)){
                    for (int i = 0; i < popsize; i++) {
                        newpop.get(i)[index] += stepindex;
                        if (newpop.get(i)[index]>up){
                            newpop.get(i)[index] = up;
                        }else if (newpop.get(i)[index]<lo){
                            newpop.get(i)[index] = lo;
                        }

                        double fold = getFitness(pop.get(i));//老解
                        double fnew = getFitness(newpop.get(i));//新解

                        if (fnew < fold || Math.random() < Math.exp(-(fnew - fold) / T)){
                            for (int j = 0; j < popsize; j++) {
                                for (int k = 0; k < dim; k++) {
                                    pop.get(i)[k] = newpop.get(i)[k];
                                }
                            }
                        }
                    }
                }

                T = T * rate;
            }

        }

        F = new double[pop.size()];
        for (int i = 0; i < pop.size(); i++) {
            F[i] = getFitness(pop.get(i));
            if (F[i] < F[bestindex]){
                bestindex = i;
            }
        }
//        System.out.println("最小适应度为："+ s[bestindex]);
        best = pop.get(bestindex);

        return best;
    }

    public static double nextDouble(final double min, final double max) {
        return min + ((max - min) * new Random().nextDouble());
    }

    public static void main(String[] args) {
        List<double[]> pop = new ArrayList<>();
        double[] r = new double[8];
        for (int i = 0; i < 4; i++) {
            r[0] = nextDouble(-11,11);
            r[1] = nextDouble(-11,11);
            r[2] = Math.abs(r[0]);
            r[3] = Math.abs(r[1]);
            r[4] = nextDouble(-11,11);
            r[5] = nextDouble(-11,11);
            r[6] = Math.abs(r[4]);
            r[7] = Math.abs(r[5]);
            pop.add(r);
            r = new double[8];
        }

//        System.out.println(pop);

        SA sa = new SA(pop.size(), 8,11,1,pop,44);
        double[] res = sa.runSA();
        System.out.println(Arrays.toString(res));
    }


}
