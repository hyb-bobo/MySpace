package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 14:30
 */
public class MyThread02 extends Thread {

    private MyObject01 myObject01;

    public MyThread02(MyObject01 myObject01){
        this.myObject01 = myObject01;
    }

    @Override
    public void run() {
        myObject01.speedPrint();
    }

    public static void main(String[] args) throws InterruptedException {
        MyService01 myService01 = new MyService01();
        MyObject01 myObject01 = new MyObject01();
        MyObject01 myObject02 = new MyObject01();
        MyThread01 myThread01 = new MyThread01(myService01,myObject01);
        myThread01.setName("AAA");
        myThread01.start();
        Thread.sleep(1000);
        MyThread02 myThread02 = new MyThread02(myObject01);
        myThread02.setName("BBB");
        myThread02.start();
    }
}
