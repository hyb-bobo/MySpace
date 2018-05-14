package Singleton;

/**
 * Author: hyb
 * Date: Created in 2018/5/14 17:24
 */
public class Singleton {

//    private static Singleton singleton = new Singleton();
    private static Singleton singleton ;
    private Singleton(){

    }

    public synchronized static Singleton getSingleton(){
//        return singleton;
        if(singleton != null){

        }else {
            singleton = new Singleton();
        }
        return singleton;
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Singleton.getSingleton().hashCode());
    }
}

class RunSingleton{
    public static void main(String[] args){
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
