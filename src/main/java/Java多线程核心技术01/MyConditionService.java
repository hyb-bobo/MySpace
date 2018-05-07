package Java多线程核心技术01;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/7 11:50
 */
public class MyConditionService {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await(){
        try {
            lock.lock();
            System.out.println("A");
            System.out.println("await 时间为："+System.currentTimeMillis());
            condition.await();
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
            lock.unlock();
            System.out.println("锁释放了");
        }
    }

    public void signal(){
        try {
            lock.lock();
            System.out.println("signal时间为:"+System.currentTimeMillis());
            condition.signal();
        }catch (Exception e){
            lock.unlock();
        }
    }
}


class ConditionThreadA extends Thread{
    private MyConditionService myConditionService;
    public ConditionThreadA(MyConditionService myConditionService){
        this.myConditionService = myConditionService;
    }

    @Override
    public void run() {
        myConditionService.await();
    }
}


class RunCondition{
    public static void main(String[] args) throws InterruptedException {
        MyConditionService myConditionService = new MyConditionService();
        ConditionThreadA conditionThreadA = new ConditionThreadA(myConditionService);
        conditionThreadA.start();
        Thread.sleep(5000);
        myConditionService.signal();
    }
}
