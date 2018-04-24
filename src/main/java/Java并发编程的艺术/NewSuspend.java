package Java并发编程的艺术;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/4/24 10:43
 */
public class NewSuspend {
    public volatile boolean suspendRequested = false;
    private Lock suspendLock = new ReentrantLock();
    private Condition suspendCondition = suspendLock.newCondition();

    public void run() {

        while (true) {
            if (suspendRequested) {
                suspendLock.lock();
                try {
                    while (suspendRequested)
                        suspendCondition.await();
                } catch (Exception e) {

                } finally {
                    suspendLock.unlock();
                }
            }
        }
    }

    public void requestSuspend() {
        suspendRequested = true;
    }

    public void requestResume() {
        suspendRequested = false;
        suspendLock.lock();
        try {
            suspendCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            suspendLock.unlock();
        }
    }
}
