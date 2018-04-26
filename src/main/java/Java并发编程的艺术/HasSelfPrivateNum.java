package Java并发编程的艺术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 10:42
 */
public class HasSelfPrivateNum {

    private int num = 0;
    public synchronized void addI(String userName) {
        try {
            if (userName.equals("A")) {
                num = 100;
                System.out.println("A is over!");

                Thread.sleep(2000);
            }else {
                num=200;
                System.out.println("B is over!");
            }
            System.out.println(userName + " num="+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
