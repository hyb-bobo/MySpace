package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 16:45
 */
public class testException {
    synchronized public void testMethod(){
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a "+System.currentTimeMillis());
            int i=1;
            while (i==1){
                if((""+Math.random()).substring(0,8).equals("0.123456")){
                    System.out.println("exception"+System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }else {
            System.out.println("b "+System.currentTimeMillis());
        }

    }
}
