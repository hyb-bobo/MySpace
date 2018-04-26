package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 16:07
 */
public class Service {

    synchronized public void service1(){
        System.out.println("service1");
        service2();
    }

    synchronized private void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized private void service3() {
        System.out.println("service3");
    }
}
