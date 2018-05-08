package Java多线程核心技术;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/8 9:23
 */
public class MyQueueLock {
    public ReentrantLock lock = new ReentrantLock();
    public void testMethod(){
        try {
            lock.lock();
            System.out.println("name " +Thread.currentThread().getName()+"进入");
//            Thread.sleep(3000);
            Thread.sleep(Integer.MAX_VALUE);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class RunQueue{
    public static void main(String[] args) throws InterruptedException {
        final MyQueueLock myQueueLock = new MyQueueLock();
        Runnable runnable = new Runnable() {
            public void run() {
                myQueueLock.testMethod();
            }
        };
        Thread[] arrThread = new Thread[10];
        for (int i=0;i<10;i++){
            arrThread[i] = new Thread(runnable);
        }
        for(int j =0;j<10;j++){
            arrThread[j].start();

        }
         System.out.println();
        Thread.sleep(1000);
        System.out.println("等待的线程数为:"+myQueueLock.lock.getQueueLength());

    }
}
