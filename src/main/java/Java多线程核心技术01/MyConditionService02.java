package Java多线程核心技术01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/7 14:04
 */
public class MyConditionService02 {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public void awaitA(){
        try {
            lock.lock();
            System.out.println("begin awaitA 时间"+System.currentTimeMillis()+" name = "+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end1 awaitA 时间"+System.currentTimeMillis()+" name = "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void awaitB(){
        try {
            lock.lock();
            System.out.println("begin awaitB 时间"+System.currentTimeMillis()+" name = "+Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB 时间"+System.currentTimeMillis()+" name = "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void singalAll_A(){
        try {
            lock.lock();
            System.out.println("signalAll_A 时间"+System.currentTimeMillis()+"  name"+Thread.currentThread().getName());
            conditionA.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void singalAll_B(){
        try {
            lock.lock();
            System.out.println("signalAll_B 时间"+System.currentTimeMillis()+"  name"+Thread.currentThread().getName());
            conditionB.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


class ThreadSingalA extends  Thread{
    private MyConditionService02 myConditionService02;
    public ThreadSingalA(MyConditionService02 myConditionService02){
        this.myConditionService02 = myConditionService02;
    }

    @Override
    public void run() {
        myConditionService02.awaitA();
    }
}


class ThreadSingalB extends  Thread{
    private MyConditionService02 myConditionService02;
    public ThreadSingalB(MyConditionService02 myConditionService02){
        this.myConditionService02 = myConditionService02;
    }

    @Override
    public void run() {
        myConditionService02.awaitB();
    }
}

class RunSingalAB{
    public static void main(String[] args) throws InterruptedException {
        MyConditionService02 myConditionService02 = new MyConditionService02();
        ThreadSingalA threadSingalA = new ThreadSingalA(myConditionService02);
        threadSingalA.setName("A");
        threadSingalA.start();
        ThreadSingalB threadSingalB = new ThreadSingalB(myConditionService02);
        threadSingalB.setName("B");
        threadSingalB.start();
        Thread.sleep(3000);
        myConditionService02.singalAll_A();

    }
}