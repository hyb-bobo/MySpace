package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 8:52
 */
public class MyWaitTest extends Thread {
    private Object obj;
    public MyWaitTest(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            synchronized (obj){
                System.out.println("开始wait="+System.currentTimeMillis());
                obj.wait();
                System.out.println("结束wait="+System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
