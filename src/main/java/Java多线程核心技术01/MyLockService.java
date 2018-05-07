package Java多线程核心技术01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/7 9:34
 */
public class MyLockService {

    private Lock lock = new ReentrantLock();

    public void methodA(){
        try {
            lock.lock();
            System.out.println("methodA begin thread name = "+Thread.currentThread().getName()
                    +"  time ="+System.currentTimeMillis());

            Thread.sleep(5000);
            System.out.println("methodA end thread name = "+Thread.currentThread().getName()+
            " time = "+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void methodB(){
        try {
            lock.lock();
            System.out.println("methodB begin thread name = "+Thread.currentThread().getName()
                    +"  time ="+System.currentTimeMillis());

            Thread.sleep(5000);
            System.out.println("methodB end thread name = "+Thread.currentThread().getName()+
                    " time = "+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class MyLockThreadA extends  Thread{
    private MyLockService myLockService;

    public MyLockThreadA(MyLockService myLockService){
        this.myLockService = myLockService;
    }

    @Override
    public void run() {
        myLockService.methodA();
    }
}

class MyLockThreadAA extends  Thread{
    private MyLockService myLockService;

    public MyLockThreadAA(MyLockService myLockService){
        this.myLockService = myLockService;
    }

    @Override
    public void run() {
        myLockService.methodA();
    }
}


class MyLockThreadB extends  Thread{
    private MyLockService myLockService;

    public MyLockThreadB(MyLockService myLockService){
        this.myLockService = myLockService;
    }

    @Override
    public void run() {
        myLockService.methodB();
    }
}

class MyLockThreadBB extends  Thread{
    private MyLockService myLockService;

    public MyLockThreadBB(MyLockService myLockService){
        this.myLockService = myLockService;
    }

    @Override
    public void run() {
        myLockService.methodB();
    }
}

class MyLockRun {

    public static void main(String[] args) throws InterruptedException {
        MyLockService myLockService = new MyLockService();
        MyLockThreadA myLockThreadA = new MyLockThreadA(myLockService);
        myLockThreadA.setName("A");
        myLockThreadA.start();
        MyLockThreadAA myLockThreadAA = new MyLockThreadAA(myLockService);
        myLockThreadAA.setName("AA");
        myLockThreadAA.start();
        Thread.sleep(200);
        MyLockThreadB myLockThreadB = new MyLockThreadB(myLockService);
        myLockThreadB.setName("B");
        myLockThreadB.start();
        MyLockThreadBB myLockThreadBB = new MyLockThreadBB(myLockService);
        myLockThreadBB.setName("BB");
        myLockThreadBB.start();
    }
}
