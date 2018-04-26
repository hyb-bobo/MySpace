package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 16:50
 */
public class TestA extends Thread {

    private testException testException;
    public TestA(testException testException){
        this.testException = testException;
    }

    @Override
    public void run() {
        testException.testMethod();
    }
}
