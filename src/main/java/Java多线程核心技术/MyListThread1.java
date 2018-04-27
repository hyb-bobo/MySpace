package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 11:16
 */
public class MyListThread1 extends Thread {
    private MyOneList list;
    public MyListThread1(MyOneList list){
        this.list = list;
    }

    @Override
    public void run() {
        MyOneListService myOneListService = new MyOneListService();
        myOneListService.addSerivce(list,"A");
    }
}
