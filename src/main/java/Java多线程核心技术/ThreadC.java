package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 16:35
 */
public class ThreadC extends Thread {
    private modelConsume modelConsume;
    public ThreadC(modelConsume modelConsume){
        super();
        this.modelConsume = modelConsume;
    }

    @Override
    public void run() {
        while (true){
            modelConsume.getValue();
        }
    }

    public static void main(String[] args){
        String lock = new String("");
        modelProduct modelProduct = new modelProduct(lock);
        modelConsume modelConsume = new modelConsume(lock);
        ThreadP threadP = new ThreadP(modelProduct);
        ThreadC threadC = new ThreadC(modelConsume);
        threadP.start();
        threadC.start();

    }
}
