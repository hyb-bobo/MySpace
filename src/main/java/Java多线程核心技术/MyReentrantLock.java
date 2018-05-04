package Java多线程核心技术;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/4 16:58
 */
public class MyReentrantLock {
    private Lock lock = new ReentrantLock();
    public void testMethod(){
        lock.lock();
        for (int i=0;i<5;i++){
            System.out.println("name = "+Thread.currentThread().getName()+" "+(i+1));
        }
        lock.unlock();
    }
}

class MyLockThread extends Thread{
    private MyReentrantLock myReentrantLock;
    public MyLockThread(MyReentrantLock myReentrantLock){
        this.myReentrantLock = myReentrantLock;
    }

    @Override
    public void run() {
        myReentrantLock.testMethod();
    }
}

class RunLock{
    public static void main(String[] args){
        MyReentrantLock myReentrantLock = new MyReentrantLock();
        MyLockThread myLockThread1 = new MyLockThread(myReentrantLock);
        MyLockThread myLockThread2 = new MyLockThread(myReentrantLock);
        MyLockThread myLockThread3 = new MyLockThread(myReentrantLock);
        MyLockThread myLockThread4 = new MyLockThread(myReentrantLock);
        MyLockThread myLockThread5 = new MyLockThread(myReentrantLock);
        myLockThread1.start();
        myLockThread2.start();
        myLockThread3.start();
        myLockThread4.start();
        myLockThread5.start();

    }

}
