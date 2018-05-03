package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 11:35
 */
public class AddThread extends Thread {
    private Add p;
    public AddThread(Add p){
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}
