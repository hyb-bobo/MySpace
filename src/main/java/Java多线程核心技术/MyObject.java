package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 11:34
 */
public class MyObject {
    public synchronized void methodA(){
        try {
            System.out.println("A name "+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end  "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void methodB(){
        try {
            System.out.println("B name "+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end  "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

