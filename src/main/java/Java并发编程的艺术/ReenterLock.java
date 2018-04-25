package Java并发编程的艺术;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/4/25 11:26
 */
public class ReenterLock implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();
    private static int i=0;
    private static int result=0;
    List<Integer> list = new ArrayList();
    public ReenterLock(int[] num){
        for (int i=0;i<num.length;i++){
            list.add(num[i]);
        }
    }
    public void run() {
        for (int j=0;j<list.size();j++){
            lock.lock();
            try {
                result += list.get(j);
                System.out.println(list.get(j)+"    "+Thread.currentThread().getName());
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] num = {1};
        ReenterLock reenterLock = new ReenterLock(num);
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        long time1 = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long time2 = System.currentTimeMillis();
        System.out.println("result:"+result);
        System.out.println(time2-time1);

    }
}
