package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 14:13
 */
public class MyObject01 {

    synchronized public void speedPrint(){
        System.out.println("get time = "+System.currentTimeMillis()+"  name = "+Thread.currentThread().getName());
        System.out.println("----------*****************---------");
        System.out.println("release time = "+System.currentTimeMillis()+"  name = "+Thread.currentThread().getName());
    }
}
