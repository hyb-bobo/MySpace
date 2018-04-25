package Java并发编程的艺术;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 默认情况下，锁的申请都是非公平的。也就是说，如果线程 1 与线程 2，都申请获得锁 A，那么谁获得锁不是一定的，
 * 是由系统在等待队列中随机挑选的。这就好比，买票的人不排队，售票姐姐只能随机挑一个人卖给他，这显然是不公平的。
 * 而公平锁，它会按照时间的先后顺序，保证先到先得。公平锁的特点是：不会产生饥饿现象。
 */
public class FairLock implements Runnable{
    public static ReentrantLock fairLock = new ReentrantLock(false);

    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"，获得锁!");
            }finally {
                fairLock.unlock();
            }
        }

    }
    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "线程1");
        Thread t2 = new Thread(fairLock, "线程2");
        t1.start();t2.start();
    }
}