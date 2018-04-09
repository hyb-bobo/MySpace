package MySpace;

/**
 * Author: hyb
 * Date: Created in 2018/4/9 10:06
 */
public class Bround extends Thread {
    public static void main(String[] args){
        Bround bround = new Bround();
        bround.run();
    }

    public void start(){
        for (int i = 0 ;i<10;i++){
            System.out.println(i);
        }
    }
}
