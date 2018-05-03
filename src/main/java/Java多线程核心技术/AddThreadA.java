package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 11:35
 */
public class AddThreadA extends Thread {
    private Subtract subtract;
    public AddThreadA(Subtract subtract){
        this.subtract = subtract;
    }

    @Override
    public void run() {
        subtract.subtract();
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);
        AddThreadA addThreadA = new AddThreadA(subtract);
        addThreadA.setName("subtract");
        addThreadA.start();
        AddThreadA addThreadA1 = new AddThreadA(subtract);
        addThreadA1.setName("subtract1");
        addThreadA1.start();
        Thread.sleep(1000);
        AddThread addThread = new AddThread(add);
        addThread.setName("AddThread");
        addThread.start();
    }
}
