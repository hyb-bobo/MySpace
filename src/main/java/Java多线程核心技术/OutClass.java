package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/28 11:07
 */
public class OutClass {
    static class Inner {
        public void method1() {
            synchronized ("其他的锁") {
                for (int i = 1; i < 11; i++) {
                    System.out.println(Thread.currentThread().getName() + " i=" + i);
                }
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void method2() {
            for (int i = 11; i < 21; i++) {
                System.out.println(Thread.currentThread().getName() + " i=" + i);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    static class InnerClass1{
        public void method12(InnerClass2 innerClass2){
            String name = Thread.currentThread().getName();
            synchronized (innerClass2){
                System.out.println(name + " 进入InnerClass1类中的method12方法");
                for (int i=0;i<10;i++){
                    System.out.println("i = "+i);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(name +" 离开InnerClass1类中的method12方法");
            }
        }
        public synchronized void method22(){
            String name = Thread.currentThread().getName();
                System.out.println(name + " 进入InnerClass1类中的method22方法");
                for (int j=0;j<10;j++){
                    System.out.println("j = "+j);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(name +" 离开InnerClass1类中的method22方法");

        }

        static class InnerClass2{
            public synchronized void method1(){
                String name = Thread.currentThread().getName();
                System.out.println(name + " 进入InnerClass2类中的method2方法");
                for (int k=0;k<10;k++){
                    System.out.println("k = "+k);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(name +" 离开InnerClass1类中的method22方法");
            }
        }
    }


    public static void main(String[] args) {
        final Inner inner = new Inner();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                inner.method1();
            }
        },"A");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                inner.method2();
            }
        },"B");

        thread1.start();
        thread2.start();

    }
}
