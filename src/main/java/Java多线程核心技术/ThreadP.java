package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 16:35
 */
public class ThreadP extends Thread {
    private modelProduct modelProduct;
    public ThreadP(modelProduct modelProduct){
        super();
        this.modelProduct = modelProduct;
    }

    @Override
    public void run() {
        while (true){
            modelProduct.setValue();
        }
    }
}
