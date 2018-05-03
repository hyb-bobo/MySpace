package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 17:03
 */
public class ModelProduct01 {

    private String lock;
    public ModelProduct01(String lock){
        this.lock = lock;
    }

    public void setValue(){
        try {

            synchronized (lock){
                while (!ValueObject.value.equals("")){
                    System.out.println("生产者"+Thread.currentThread().getName()+" waiting 了");
                    lock.wait();
                }
                System.out.println("生产者"+Thread.currentThread().getName()+" Running 了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set 的值是"+value);
                ValueObject.value = value;
                lock.notifyAll();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
