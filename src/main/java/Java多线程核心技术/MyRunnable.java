package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 10:13
 */
public class MyRunnable {

    static private Object lock = new Object();
    static private Runnable runnable = new Runnable() {
        public void run() {
            try{
                synchronized (lock){
                    System.out.println("wait begin ="+System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end ="+System.currentTimeMillis());
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    };


    static private Runnable runnable2 = new Runnable() {
        public void run() {
            try{
                synchronized (lock){
                    System.out.println("notify begin ="+System.currentTimeMillis());
                    lock.notify();
                    System.out.println("notify  end ="+System.currentTimeMillis());
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    };

    /**
     * 日志打印效果
     * wait begin =1525314686952
     * notify begin =1525314689951
     * notify  end =1525314689951
     * wait end =1525314689952
     *
     * 可以发现wait begin是在6952被执行
     * 然后notify begin是在9951被执行
     * 然后是wait end是在wait end 被执行
     * 而wait本身是需要等待5s的
     * 但是实际上wait 3s后就被执行了
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(3000);
        Thread thread1 = new Thread(runnable2);
        thread1.start();
    }
}
