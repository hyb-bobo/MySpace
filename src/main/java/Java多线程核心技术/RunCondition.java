package Java多线程核心技术;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/8 10:31
 */
public class RunCondition {
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition condition = lock.newCondition();
}

class F{
    volatile public static int nextPrintWho = 1;
}
