package Others;


import java.util.*;

/**
 *  遗传算法 Created by Ping on 2019/5/16.
 */

public class GA {
    private int N = 100;	//染色体数量
    private List<double[]> pop ; //输入的解集 即一个种群中染色体总数
    private int generation = 0; 	//染色体代号
    public  int GENE; 		//基因数即维度
    private int bestindex = 0;  //函数最优解
    private int bestgenerations;   	//所有子代与父代中最好的染色体
    private double[] best;   		//最优解的染色体的二进制码

    private double up;
    private double lo;

    private double elite = 0.2; //直接遗传比例

    private double[] F;    // Fitness (N)

    private List<Double> mipslist ;
    private List<Integer> lengthlist ;

    private final Random rand = new Random();

    public GA(int N,int GENE,double up, double lo, List<double[]> pop, List<Double> mipslist, List<Integer> lengthlist){
        // Initialize Variable
        this.N = N;
        this.GENE = GENE;
        this.pop = pop;
        this.mipslist = mipslist;
        this.lengthlist = lengthlist;

        this.up = up;
        this.lo = lo;

        this.F = new double[N];
    }

    public GA(int N,int GENE,double up, double lo, List<double[]> pop){
        this.N = N;
        this.GENE = GENE;
        this.pop = pop;

        this.up = up;
        this.lo = lo;

        this.F = new double[N];
    }


//    private double getFitness(double[] Xi){
//        int N = Xi.length;
//        double cost = 0.0;
//        for (int i = 0; i < N; i++) {
//            cost += lengthlist.get(i)/mipslist.get((int)Xi[i]);
//        }
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            sum += Xi[i];
//        }
//        return sum+cost;
//    }
    private double getFitness(double[] Xi){
        int sum = 0;
        for (int i = 0; i < Xi.length; i++) {
            sum += Xi[i];
        }

        return sum;
    }

//    private void select(){
//        double p[] = new double[pop.size()]; // 各染色体选择概率
//        double q[] = new double[pop.size()]; // 累计概率
//
//        double sumF = 0.0; // 累计适应值总和
//
//        for (int i = 0; i < pop.size(); i++) {
//            F[i] = getFitness(pop.get(i));
//
//            if (F[i] > bestfitness){  // 记录下种群中的最小值，即最优解
//                bestfitness = F[i];
//                bestgenerations = generation;
//                best = pop.get(i);
//            }
//
//            sumF += F[i];
//        }
//
//        for (int i = 0; i < pop.size(); i++) {
//            p[i] = F[i]/sumF;   //每个染色体的选择概率
//
//            if (i == 0)
//                q[i] = p[i];
//            else {
//                q[i] = q[i - 1] + p[i];
//            }
//
//        }
//
//        for (int i = 0; i < pop.size(); i++) {
//            q[i] /= sumF;
//        }
//
//        for (int i = 0; i < pop.size(); i++) {
//            double r = Math.random();
//            for (int j = 0; j < pop.size(); j++) {
//                if (j == 0){
//                    if (r > 0 && r <= q[j]){
//                        for (int k = 0; k < GENE; k++) {
//                            pop.get(i)[k] = pop.get(j)[k];
//                        }
//                    }
//                }else {
//                    if (r > q[j - 1] && r <= q[j]){
//                        for (int k = 0; k < GENE; k++) {
//                            pop.get(i)[k] = pop.get(j)[k];
//                        }
//                    }
//                }
//            }
//        }
//
//    }
    //两两交叉
    private List<double[]> cross(double[] p1, double[] p2){
        int pos = rand.nextInt(GENE);
        List<double[]> res = new ArrayList<>();

        double[] temp1 = new double[pos];
        double[] temp2 = new double[pos];
        for (int i = 0; i < pos; i++) {
            temp1[i] = p1[i];
            temp2[i] = p2[i];
            p1[i] = temp2[i];
            p2[i] = temp1[i];
        }
        res.add(p1);
        res.add(p2);

        return res;


    }

    //两两变异
    private double[] mutation(double[] p){
        //变异的点的个数
        int num = (int) (GENE * elite);
        //变异的点的位置
        int l = p.length-1;
        int pos = rand.nextInt(l);
        for (int i = 0; i < num; i++) {
            //变动幅度为2
            p[pos] = rand.nextInt(2);
        }
        return p;
    }

    public double[] runGA(){
        //这里求解调度问题还是不要用sb轮盘赌了,用种群选择概率吧
        Map<Double, double[]> map = new HashMap<>();
        List<double[]> newpop = new ArrayList<>();
        List<double[]> npop = new ArrayList<>();

        for (int iter = 0; iter < 100; iter++) {
            for (int i = 0; i < pop.size(); i++) {
                F[i] = getFitness(pop.get(i));
                map.put(F[i],pop.get(i));
            }
            //从小到大排序
            Arrays.sort(F);
            //种群按照fit的值从小到大排列
            for (int i = 0; i < F.length; i++) {
                newpop.add(map.get(F[i]));
            }

            //每一代中有多少胜出者
            int topelite = (int)(elite * newpop.size());

            //按照比例选择直接遗传
            for (int i = 0; i < topelite; i++) {
                npop.add(newpop.get(i));
            }
//            System.out.println(npop);

            while (npop.size()<pop.size()){
                //变异
                if (Math.random()<0.1){
                    int pos = rand.nextInt(topelite);
                    npop.add(mutation(newpop.get(pos)));
                }else {
                    //交叉
                    int pos1 = rand.nextInt(topelite);
                    int pos2 = rand.nextInt(topelite);
                    npop.addAll(cross(newpop.get(pos1),newpop.get(pos2)));
                }
            }
            for (int i = 0; i < npop.size(); i++) {
                System.out.println("解"+Arrays.toString(npop.get(i)));
            }

        }

        double[] s = new double[npop.size()];
        for (int i = 0; i < npop.size(); i++) {
            s[i] = getFitness(npop.get(i));
            if (s[i] < s[bestindex]){
                bestindex = i;
            }
        }
        System.out.println("最小适应度为："+ s[bestindex]);
        best = npop.get(bestindex);


        return best;
    }

    public static void main(String[] args) {
        List<double[]> poplist = new ArrayList<>();
        Random rand = new Random();
        double[] r = new double[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                r[j] = rand.nextInt(8);
            }
            poplist.add(r);
            r = new double[10];
        }
        double[] a = new double[]{7,7,7,7,7,7,7,7,7,7};
        poplist.add(a);
//        for (int i = 0; i < poplist.size(); i++) {
//            System.out.println(Arrays.toString(poplist.get(i)));
//        }

        GA ga = new GA(10,10,0,7,poplist);
        double[] best = ga.runGA();
        System.out.println(Arrays.toString(best));


    }


}
