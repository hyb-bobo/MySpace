package Java并发编程的艺术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 8:50
 */
public class CountOperate extends Thread {
    public CountOperate(){
        System.out.println("CountOperate begin");
        System.out.println("ThreadName "+Thread.currentThread().getName());
        System.out.println("this.name "+this.getName());
        System.out.println("CountOperate end");
    }

    @Override
    public void run() {
        System.out.println("run begin");
        System.out.println("ThreadName "+Thread.currentThread().getName());
        System.out.println("this.name "+this.getName());
        System.out.println("run end");
    }

    public static void main(String[] args){
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.setName("AAAAA");
        thread.start();
    }
}
