package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 17:11
 */
public class ModelConsume01 {
    private String lock;
    public ModelConsume01(String lock){
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                if(ValueObject.value.equals("")){
                    System.out.println("消费者"+Thread.currentThread().getName()+" waiting 了");
                    lock.wait();
                }
                System.out.println("消费者"+Thread.currentThread().getName()+" Running 了");
                ValueObject.value = "";
                System.out.println(ValueObject.value);
                lock.notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        ModelProduct01 modelProduct01 = new ModelProduct01(lock);
        ModelConsume01 modelConsume01 = new ModelConsume01(lock);
        ThreadP[] threadPS = new ThreadP[2];
        ThreadC[] threadCS = new ThreadC[2];
        for (int i=0;i<2;i++){
            threadPS[i] = new ThreadP(modelProduct01);
            threadPS[i].setName("生产者"+(i+1));
            threadCS[i] = new ThreadC(modelConsume01);
            threadCS[i].setName("消费者"+(i+1));
            threadPS[i].start();
            threadCS[i].start();
        }

        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        int enumerate = Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0;i<threadArray.length;i++){
            System.out.println(threadArray[i].getName()+"_"+threadArray[i].getState());
        }

    }
}
