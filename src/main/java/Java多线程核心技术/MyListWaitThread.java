package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/2 14:35
 */
public class MyListWaitThread extends Thread {

    private MyListWait myListWait;
    public MyListWaitThread(MyListWait myListWait){
        this.myListWait = myListWait;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                myListWait.add();
                System.out.println("添加了"+(i+1)+"个元素");
//                Thread.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
