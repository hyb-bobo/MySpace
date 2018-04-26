package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 11:36
 */
public class ThreadA extends Thread {
    private MyObject myObject;
    public ThreadA(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodA();
    }
}
