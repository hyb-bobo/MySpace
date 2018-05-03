package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 9:05
 */
public class MyListSizeThreadB extends Thread {
    private Object obj;
    public MyListSizeThreadB( Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            synchronized (obj){
                for(int i=0;i<10;i++){
                    MyListSize.add();
                    if(MyListSize.size() == 5){
                        obj.notify();
                        System.out.println("notify 发出");
//                        System.exit(1);
                    }

                    System.out.println("添加了"+(i+1)+"个元素");
//                    Thread.sleep(1000);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        try {
            Object obj = new Object();
            MyListSizeThreadA myListSizeThreadA = new MyListSizeThreadA(obj);
            myListSizeThreadA.start();
            Thread.sleep(100);
            MyListSizeThreadB myListSizeThreadB = new MyListSizeThreadB(obj);
            myListSizeThreadB.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
