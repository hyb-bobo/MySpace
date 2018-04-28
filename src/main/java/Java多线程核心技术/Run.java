package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/28 9:59
 */
public class Run {
    public static void main(String[] args){
        try {
            DealThread dealThread1 = new DealThread();
            dealThread1.setFlag("a");
            Thread thread1 = new Thread(dealThread1);
            thread1.start();
            Thread.sleep(1000);
            dealThread1.setFlag("b");
            Thread thread2 = new Thread(dealThread1);
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
