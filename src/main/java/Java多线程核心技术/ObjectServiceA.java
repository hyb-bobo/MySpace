package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 9:00
 */
public class ObjectServiceA extends Thread {
    private ObjectService objectService;
    public ObjectServiceA(ObjectService objectService){
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodA();
    }
}
