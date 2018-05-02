package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/2 11:29
 */
public class PrintStringNew  implements Runnable{
    public void run() {
        printStringMethod();
    }

    private boolean isContinuePrint = true;
    public boolean isContinuePrint(){
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod(){
        try{
            while (isContinuePrint == true){
                System.out.println("Thread name = "+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (Exception e){

        }

    }

    public static void main(String[] args) throws InterruptedException {
        PrintStringNew printString = new PrintStringNew();
        new Thread(printString).start();
        System.out.println("stop it! stop name = "+Thread.currentThread().getName());
//        Thread.sleep(1000);
        printString.setContinuePrint(false);
    }
}
