package Java多线程核心技术;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: hyb
 * Date: Created in 2018/5/2 13:47
 */
public class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for(int i=0;i<=10;i++){
            System.out.println(count.incrementAndGet());
        }
    }

    public static void main(String[] args){
        AddCountThread addCountThread = new AddCountThread();
        Thread thread1 = new Thread(addCountThread);
        thread1.start();
        Thread thread2 = new Thread(addCountThread);
        thread2.start();
        Thread thread3 = new Thread(addCountThread);
        thread3.start();
        Thread thread4 = new Thread(addCountThread);
        thread4.start();
        Thread thread5 = new Thread(addCountThread);
        thread5.start();
    }
}
