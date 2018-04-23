package javaConcurrent;

/**
 * yield方法的作用是暂停当前线程，以便其他线程有机会执行，不过不能指定暂停的时间，并且也不能保证当前线程马上停止。yield方法只是将Running状态转变为Runnable状态。
 */

/**
 * 这个例子就是通过yield方法来实现两个线程的交替执行。不过请注意：这种交替并不一定能得到保证，源码中也对这个问题进行说明：
 */

/**
 * A hint to the scheduler that the current thread is willing to yield
 * its current use of a processor. The scheduler is free to ignore this
 * hint.
 *
 * <p> Yield is a heuristic attempt to improve relative progression
 * between threads that would otherwise over-utilise a CPU. Its use
 * should be combined with detailed profiling and benchmarking to
 * ensure that it actually has the desired effect.
 *
 * <p> It is rarely appropriate to use this method. It may be useful
 * for debugging or testing purposes, where it may help to reproduce
 * bugs due to race conditions. It may also be useful when designing
 * concurrency control constructs such as the ones in the
 * {@link java.util.concurrent.locks} package.
 *
 * 这段话主要说明了三个问题：

 　　调度器可能会忽略该方法。
 　　使用的时候要仔细分析和测试，确保能达到预期的效果。
 　　很少有场景要用到该方法，主要使用的地方是调试和测试。
 */
public class YieldTest implements Runnable {
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldTest runn = new YieldTest();
        Thread t1 = new Thread(runn,"FirstThread");
        Thread t2 = new Thread(runn,"SecondThread");

        t1.start();
        t2.start();
    }
}