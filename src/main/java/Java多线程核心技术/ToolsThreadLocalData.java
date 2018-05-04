package Java多线程核心技术;

import java.util.Date;

/**
 * Author: hyb
 * Date: Created in 2018/5/4 16:02
 */
public class ToolsThreadLocalData {

    public static ThreadLocal<Date> date = new ThreadLocal<Date>();
}

class ThreadLocalDataA extends  Thread{
    @Override
    public void run() {
        try {
            for (int i = 0;i<20;i++){
                /**
                 * java.lang.NullPointerException
                 * 第一调用的时候 返回值是null
                 * 如果不设定值的话 会报空指针异常
                 */
                if(ToolsThreadLocalData.date.get() == null){
                    ToolsThreadLocalData.date.set(new Date());
                }
                System.out.println("A "+ToolsThreadLocalData.date.get().getTime());
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadLocalDataB extends  Thread{
    @Override
    public void run() {
        try {
            for (int i = 0;i<20;i++){
                if(ToolsThreadLocalData.date.get() == null){
                    ToolsThreadLocalData.date.set(new Date());
                }
                System.out.println("B "+ToolsThreadLocalData.date.get().getTime());
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class RunData{
    public static void main(String[] args){
        try {
            ThreadLocalDataA threadLocalDataA = new ThreadLocalDataA();
            threadLocalDataA.start();
            Thread.sleep(1000);
            ThreadLocalDataB threadLocalDataB = new ThreadLocalDataB();
            threadLocalDataB.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
