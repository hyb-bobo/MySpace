package javaConcurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: hyb
 * Date: Created in 2018/4/20 15:03
 */
public class CasTest {
//    public static int count = 0;
    public static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args){
        // 开启两个线程
        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 每次线程中让count值自增100次
                    for (int j = 0;j<100;j++){
//                        synchronized (CasTest.class){
//                            count++;
//                        }
                        count.incrementAndGet();

                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count = "+count);
    }
}
