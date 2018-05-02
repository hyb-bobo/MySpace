package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/2 11:17
 */
public class PrintString {

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

    public static void main(String[] args){
        PrintString printString = new PrintString();
        printString.printStringMethod();
        System.out.println("stop it!"+Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
