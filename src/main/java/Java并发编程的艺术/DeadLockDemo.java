package Java并发编程的艺术;

/**
 * 这段代码会引起死锁，使线程t1和线程t2互相等待对方释放锁。
 * 这段代码只是演示死锁的场景，在现实中你可能不会写出这样的代码。但是，在一些更为
 * 复杂的场景中，你可能会遇到这样的问题，比如t1拿到锁之后，因为一些异常情况没有释放锁
 * 死循环）。又或者是t1拿到一个数据库锁，释放锁的时候抛出了异常，没释放掉。
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}