package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 16:10
 * 支持可重入锁
 */
public class MyThreadService extends Thread {
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }

    public static void main(String[] args){
        MyThreadService myThreadService = new MyThreadService();
        myThreadService.start();
    }
}
