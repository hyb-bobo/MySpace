package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 11:37
 */
public class ThreadB extends Thread{

    private MyObject myObject;
    public ThreadB(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodB();

    }

    public static void main(String[] args){
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
