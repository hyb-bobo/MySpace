package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/4 15:02
 */
public class MyJoinThread extends Thread {
    @Override
    public void run() {
        try {

            int value = (int) (Math.random() * 10000);
            System.out.println(value);
            Thread.sleep(value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Test{
    public static void main(String[] args){
        try {
            MyJoinThread myJoinThread = new MyJoinThread();
            myJoinThread.start();
            myJoinThread.join();
            System.out.println("aaa");
            System.out.println("sss");
            System.out.println("ddd");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
