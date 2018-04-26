package Java并发编程的艺术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 10:47
 */
public class ThreadA extends Thread {
    private HasSelfPrivateNum numRef;
    public ThreadA(HasSelfPrivateNum numRef){
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("A");
    }
}
