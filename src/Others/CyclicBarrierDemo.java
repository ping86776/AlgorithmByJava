package Others;

import java.util.concurrent.*;

/**
 *  Created by Ping on 2019/7/8.
 */
public class CyclicBarrierDemo {
    private static CountDownLatch endSignal = new CountDownLatch(6);  //统计比赛结束
    //指定必须有6个运动员到达才行
    private static CyclicBarrier barrier = new CyclicBarrier(6, new Runnable() {
        @Override
        public void run() {
            System.out.println("比赛开始");
        }
    });

    public static void main(String[] args) throws Exception{
        System.out.println("运动员进场");

        ExecutorService service = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 运动员，进场");
                        barrier.await();
                        System.out.println(Thread.currentThread().getName() + "  运动员出发");

                        Thread.sleep((long)(Math.random() * 10000));//模拟每个运动员(线程)速度不一样

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }finally {
                        endSignal.countDown();
                        System.out.println(Thread.currentThread().getName() + "  运动员，到达终点");
                    }
                }
            });
        }

        endSignal.await();
        System.out.println("比赛结束");
        service.shutdown();
    }

}
