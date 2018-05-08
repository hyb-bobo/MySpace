package Java多线程核心技术01;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/7 14:57
 */
public class MyCpMany {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set(){
        try {
            lock.lock();
            while (hasValue == true){
                System.out.println("有可能连续++++++");
                condition.await();
            }
            System.out.println("++++++");
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
                System.out.println("有可能连续55555");
                condition.await();
            }
            System.out.println("55555");
            hasValue = false;
            condition.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
