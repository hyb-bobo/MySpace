package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/4 15:37
 */
public class ToolsThreadLocal {
    public static ThreadLocal t1 = new ThreadLocal();
}

class ThreadLocalA extends  Thread{
    @Override
    public void run() {
        try {
            for (int i=0;i<100;i++){
                ToolsThreadLocal.t1.set("ThreadLocalA"+(i+1));
                System.out.println("ThreadLocalA value = "+ToolsThreadLocal.t1.get());
//                Thread.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadLocalB extends  Thread{
    @Override
    public void run() {
        try {
            for (int i=0;i<100;i++){
                ToolsThreadLocal.t1.set("ThreadLocalB"+(i+1));
                System.out.println("ThreadLocalB value = "+ToolsThreadLocal.t1.get());
//                Thread.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class RunLocal{
    public static void main(String[] args){
        try {
            ThreadLocalA threadLocalA = new ThreadLocalA();
            ThreadLocalB threadLocalB = new ThreadLocalB();
            threadLocalA.start();
            threadLocalB.start();
            for (int i=0;i<100;i++){
                ToolsThreadLocal.t1.set("main"+(i+1));
                System.out.println("main get value = "+ToolsThreadLocal.t1.get());
//                Thread.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
