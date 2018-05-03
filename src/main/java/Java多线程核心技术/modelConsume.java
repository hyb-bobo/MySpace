package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 14:04
 */
public class modelConsume {

    private String lock;
    public modelConsume(String lock){
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                if(ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("-----get的值是"+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
