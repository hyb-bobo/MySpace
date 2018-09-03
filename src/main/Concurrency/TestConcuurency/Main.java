package TestConcuurency;

import sun.rmi.runtime.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args)
    {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 200; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
//                    Log.e(, Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
        /*boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);*/
    }
}