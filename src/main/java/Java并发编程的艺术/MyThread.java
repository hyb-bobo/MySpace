package Java并发编程的艺术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 8:37
 */
public class MyThread extends Thread {

    private int i=5;

    @Override
    public synchronized void run() {
        System.out.println("i="+(i--)+" ThreadName:"+Thread.currentThread().getName());
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        Thread thread4 = new Thread(myThread);
        Thread thread5 = new Thread(myThread);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
