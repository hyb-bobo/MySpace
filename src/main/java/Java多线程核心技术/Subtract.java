package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 10:58
 */
public class Subtract {

    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
//                if(ValueObject.list.size() == 0){
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin =" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end =" + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size = " + ValueObject.list.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
