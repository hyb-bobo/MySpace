package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 11:16
 */
public class MyListThread2 extends Thread{

    private MyOneList list;
    public MyListThread2(MyOneList list){
        this.list = list;
    }

    @Override
    public void run() {
        MyOneListService myOneListService = new MyOneListService();
        myOneListService.addSerivce(list,"B");
    }

    public static void main(String[] args) throws InterruptedException {
        MyOneList myOneList = new MyOneList();
        MyListThread1 myListThread1 = new MyListThread1(myOneList);
        myListThread1.setName("A");
        myListThread1.start();
//        myListThread1.setPriority(10);
//        Thread.sleep(5000);
        MyListThread2 myListThread2 = new MyListThread2(myOneList);
        myListThread2.setName("B");
        myListThread2.start();
        Thread.sleep(5000);
        System.out.println("myOneList ="+myOneList.getSize());

    }
}
