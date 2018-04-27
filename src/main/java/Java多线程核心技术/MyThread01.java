package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 14:30
 */
public class MyThread01 extends Thread {
    private MyObject01 myObject01;
    private MyService01 myService01;
    public MyThread01(MyService01 myService01,MyObject01 myObject01){
        this.myService01 = myService01;
        this.myObject01 = myObject01;
    }

    @Override
    public void run() {
        myService01.testMethod(myObject01);
    }
}
