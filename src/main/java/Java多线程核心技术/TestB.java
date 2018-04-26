package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 16:51
 */
public class TestB extends Thread{

    private testException testException;
    public TestB(testException testException){
        this.testException = testException;
    }

    @Override
    public void run() {
        testException.testMethod();
    }

    /**
     * 线程a出现异常并释放锁  线程b进入方法。结论就是 出现异常的锁会自动释放
     * @param args
     */
    public static void main(String[] args){
        try {
            testException testException = new testException();
            TestA testA = new TestA(testException);
            testA.setName("a");
            testA.start();
            Thread.sleep(5000);
            TestB testB = new TestB(testException);
            testB.setName("b");
            testB.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
