package Java多线程核心技术01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/7 13:38
 */
public class MyConditionService01 {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void awaitA(){
        try {
            lock.lock();
            System.out.println("begin awaitA 时间"+System.currentTimeMillis());
            System.out.println("name = "+Thread.currentThread().getName());
            condition.await();
            System.out.println("end awaitA 时间"+System.currentTimeMillis());
            System.out.println("name = "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println("begin awaitB 时间"+System.currentTimeMillis());
            System.out.println("name = "+Thread.currentThread().getName());
            condition.await();
            System.out.println("end awaitB 时间"+System.currentTimeMillis());
            System.out.println("name = "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void singalAll(){
        try {
            lock.lock();
            System.out.println("signalAll 时间"+System.currentTimeMillis());
            System.out.println("name"+Thread.currentThread().getName());
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

class ThreadA extends  Thread{
    private MyConditionService01 myConditionService01;
    public ThreadA(MyConditionService01 myConditionService01){
        this.myConditionService01 = myConditionService01;
    }

    @Override
    public void run() {
        myConditionService01.awaitA();
    }
}


class ThreadB extends  Thread{
    private MyConditionService01 myConditionService01;
    public ThreadB(MyConditionService01 myConditionService01){
        this.myConditionService01 = myConditionService01;
    }

    @Override
    public void run() {
        myConditionService01.awaitB();
    }
}

class RunMy{
    public static void main(String[] args) throws InterruptedException {
        MyConditionService01 myConditionService01 = new MyConditionService01();
        ThreadA threadA = new ThreadA(myConditionService01);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(myConditionService01);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(3000);
        myConditionService01.singalAll();

    }
}