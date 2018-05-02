package Java多线程核心技术;


/**
 * Author: hyb
 * Date: Created in 2018/5/2 14:38
 */
public class MyListWaitThreadB  extends  Thread{

    private MyListWait myListWait;

    public MyListWaitThreadB(MyListWait myListWait){
        this.myListWait = myListWait;
    }

    @Override
    public void run() {
        try{
            while (true){
                if(myListWait.size() == 5){
                    System.out.println("长度为5 线程退出!");
                    throw  new InterruptedException();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        MyListWait myListWait = new MyListWait();
        MyListWaitThread myListWaitThread = new MyListWaitThread(myListWait);
        myListWaitThread.setName("AAA");
        myListWaitThread.start();
        MyListWaitThreadB myListWaitThreadB = new MyListWaitThreadB(myListWait);
        myListWaitThreadB.setName("BBB");
        myListWaitThreadB.start();
    }
}
