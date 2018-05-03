package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 14:03
 */
public class modelProduct {

    private String lock;
    public modelProduct(String lock){
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                if(!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set 的值是"+value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
