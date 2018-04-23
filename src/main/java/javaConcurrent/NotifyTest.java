package javaConcurrent;

/**
 * 输出结果如下：

 Thread-0 Start-----
 Thread-1 Start-----
 Thread-2 Start-----
 Thread-3 Start-----
 Thread-4 Start-----
 Thread-0 End-------
 -----------分割线-------------
 Thread-4 End-------
 Thread-3 End-------
 Thread-2 End-------
 Thread-1 End-------

 // 从结果可以看出：调用notify方法时只有线程Thread-0被唤醒，但是调用notifyAll时，所有的线程都被唤醒了。

 还有其他的一种可能性
 Thread-1 Start-----
 Thread-4 Start-----
 Thread-3 Start-----
 Thread-0 Start-----
 Thread-2 Start-----
 -----------分割线-------------
 Thread-2 End-------
 Thread-0 End-------
 Thread-3 End-------
 Thread-4 End-------
 Thread-1 End-------
 从结果可以看出：似乎没有任何一个线程被唤醒，但是如果将Thread.sleep(3000);的时间改得更长一点，你会发现，必然会有一个线程被唤醒了

 最后，有两点点需要注意：
 　　（1）调用wait方法后，线程是会释放对monitor对象的所有权的。
 　　（2）一个通过wait方法阻塞的线程，必须同时满足以下两个条件才能被真正执行：
 　　　　线程需要被唤醒（超时唤醒或调用notify/notifyll）。
 　　　　线程唤醒后需要竞争到锁（monitor）。





 wait sleep区别
 sleep方法的作用是让当前线程暂停指定的时间（毫秒），sleep方法是最简单的方法。
 最简单的区别是，wait方法依赖于同步，而sleep方法可以直接调用。而更深层次的区别在于sleep方法只是暂时让出CPU的执行权，并不释放锁。而wait方法则需要释放锁。
 */
public class NotifyTest {
    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName() +" Start-----");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                public void run() {
                    test.testWait();
                }
            }).start();
        }

        synchronized (test) {
            test.notify();
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");
        
        synchronized (test) {
            test.notifyAll();
        }
    }
}