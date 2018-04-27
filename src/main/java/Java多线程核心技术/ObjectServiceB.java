package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 9:00
 */
public class ObjectServiceB extends Thread{
    private ObjectService objectService;
    public ObjectServiceB(ObjectService objectService){
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
    public static void main(String[] args){
        ObjectService objectService = new ObjectService();
        ObjectServiceA objectServiceA = new ObjectServiceA(objectService);
        objectServiceA.setName("AAAAA");
        objectServiceA.start();
        ObjectServiceB objectServiceB = new ObjectServiceB(objectService);
        objectServiceB.setName("BBBBB");
        objectServiceB.start();
        objectServiceB.setPriority(10);
    }
}
