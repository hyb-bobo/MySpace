package Java多线程核心技术;


/**
 * Author: hyb
 * Date: Created in 2018/5/3 10:55
 */
public class Add {
    private String lock;
    public Add(String lock){
        this.lock = lock;
    }

    public void add(){
        synchronized (lock){
            ValueObject.list.add("sssss");
            lock.notifyAll();
//            lock.notify();
        }
    }
}
