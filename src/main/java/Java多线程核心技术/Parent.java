package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 16:16
 */
public class Parent {
    public int i=10;
    synchronized public void getNum(){
        try{
            i--;
            System.out.println("parent i ="+i);
//            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Sub extends Parent{
    synchronized public void getNumSub(){
        try {
            while (i>0){
                i--;
                System.out.println("sub i="+i);
//                Thread.sleep(1000);
                this.getNum();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.getNumSub();
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
