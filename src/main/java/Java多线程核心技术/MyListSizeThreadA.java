package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 9:05
 */
public class MyListSizeThreadA extends Thread{
    private Object obj;
    public MyListSizeThreadA(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            synchronized (obj){
                if(MyListSize.size() != 5){
                    System.out.println("开始wait = "+System.currentTimeMillis());
                    obj.wait();
                    System.out.println("结束wait = "+System.currentTimeMillis());
//                    System.exit(1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
