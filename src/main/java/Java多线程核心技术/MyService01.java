package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 14:22
 */
public class MyService01 {

    public void testMethod(MyObject01 myObject01){
        synchronized (myObject01){
            try {
                System.out.println("get time = "+System.currentTimeMillis()+"  name = "+Thread.currentThread().getName());
                System.out.println("------hhhhhhhhh--------");
                Thread.sleep(5000);
                System.out.println("release time = "+System.currentTimeMillis()+"  name = "+Thread.currentThread().getName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
