package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 8:55
 */
public class MyWaitTest1 extends Thread {

    private Object obj;
    public MyWaitTest1(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            synchronized (obj){
                System.out.println("开始notify="+System.currentTimeMillis());
                obj.notify();
                System.out.println("结束notify="+System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            Object obj = new Object();
            MyWaitTest myWaitTest = new MyWaitTest(obj);
            myWaitTest.start();
            Thread.sleep(3000);
            MyWaitTest1 myWaitTest1 = new MyWaitTest1(obj);
            myWaitTest1.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
