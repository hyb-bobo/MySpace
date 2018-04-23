package javaConcurrent;

/**
 *   对比JoinTest1 和 JoinTest
 * 　对比两段代码的执行结果很容易发现，在没有使用join方法之间，线程是并发执行的，而使用join方法后，所有线程是顺序执行的。
 */
public class JoinTest1 implements Runnable{
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " start-----");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++) {
            Thread test = new Thread(new JoinTest());
            test.start();
            try {
                test.join(); //调用join方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished~~~");
    }
}