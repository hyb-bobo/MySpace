package TestConcuurency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hyb on 2018/9/3.
 */
public class DatabaseHealthChecker extends BaseHealthChecker{

    public DatabaseHealthChecker(CountDownLatch latch) {
        super("DatabaseHealthChecker Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }

}
