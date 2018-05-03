package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 16:35
 */
public class ThreadP extends Thread {
    private modelProduct modelProduct;
    private ModelProduct01 modelProduct01;
    public ThreadP(modelProduct modelProduct){
        super();
        this.modelProduct = modelProduct;
    }

    public ThreadP(ModelProduct01 modelProduct01){
        super();
        this.modelProduct01 = modelProduct01;
    }
    @Override
    public void run() {
        while (true){
            modelProduct01.setValue();
        }
    }
}
