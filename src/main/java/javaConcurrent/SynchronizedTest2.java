package javaConcurrent;
 
 public class SynchronizedTest2 {
     public static synchronized void method1(){
         System.out.println("Method 1 start");
         try {
             System.out.println("Method 1 execute");
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("Method 1 end");
     }
 
     public static synchronized void method2(){
         System.out.println("Method 2 start");
         try {
             System.out.println("Method 2 execute");
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("Method 2 end");
     }
 
     public static void main(String[] args) {
         final SynchronizedTest2 test = new SynchronizedTest2();
         final SynchronizedTest2 test2 = new SynchronizedTest2();
 
         new Thread(new Runnable() {
             public void run() {
                 test.method1();
             }
         }).start();
 
         new Thread(new Runnable() {
             public void run() {
                 test2.method2();
             }
         }).start();
     }
 }