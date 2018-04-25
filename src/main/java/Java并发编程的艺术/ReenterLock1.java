package Java并发编程的艺术;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock1 implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    private  int result=100000;
    public void run() {
        for (int j = 0;j<result;j++) {
            lock.lock();
//            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
//                lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReenterLock1 reenterLock = new ReenterLock1();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}