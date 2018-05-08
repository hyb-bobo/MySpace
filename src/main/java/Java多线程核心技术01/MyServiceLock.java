package Java多线程核心技术01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/7 14:28
 */
public class MyServiceLock {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set(){
        try {
            lock.lock();
            while (hasValue == true){
                condition.await();
            }
            System.out.println("+++++");
            hasValue = true;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while (hasValue == false){
                condition.await();
            }
            System.out.println("--------");
            hasValue = false;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class CpThreadA extends  Thread{
    private MyServiceLock myServiceLock;
    public CpThreadA(MyServiceLock myServiceLock){
        this.myServiceLock = myServiceLock;
    }

    @Override
    public void run() {
        for(int i=0;i<Integer.MAX_VALUE;i++){
            myServiceLock.set();
        }
    }
}

class CpThreadB extends  Thread{
    private MyServiceLock myServiceLock;
    public CpThreadB(MyServiceLock myServiceLock){
        this.myServiceLock = myServiceLock;
    }

    @Override
    public void run() {
        for(int i=0;i<Integer.MAX_VALUE;i++){
            myServiceLock.get();
        }
    }
}

class RunCp{
    public static void main(String[] args){
        MyServiceLock myServiceLock = new MyServiceLock();
        CpThreadA cpThreadA = new CpThreadA(myServiceLock);
        cpThreadA.start();
        CpThreadB cpThreadB = new CpThreadB(myServiceLock);
        cpThreadB.start();
    }
}
