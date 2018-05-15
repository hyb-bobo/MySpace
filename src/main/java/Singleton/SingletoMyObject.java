package Singleton;

/**
 * Author: hyb
 * Date: Created in 2018/5/15 9:07
 * 使用静态内部类实现单例模式(在没有遇到序列化对象时是可以采用这种方式的)
 */
public class SingletoMyObject {
    private static class SingletoMyObjectHandler{
        private static SingletoMyObject singletoMyObject = new SingletoMyObject();
    }

    public static SingletoMyObject getSingletoMyObject(){
        return SingletoMyObjectHandler.singletoMyObject;
    }
}


class SingletoMyObjectHandlerThread extends  Thread{
    @Override
    public void run() {
        System.out.println(SingletoMyObject.getSingletoMyObject().hashCode());
    }
}


class RunSingletoMyObject{
    public static void main(String[] args){
        SingletoMyObjectHandlerThread Thread1 = new SingletoMyObjectHandlerThread();
        SingletoMyObjectHandlerThread Thread2 = new SingletoMyObjectHandlerThread();
        SingletoMyObjectHandlerThread Thread3 = new SingletoMyObjectHandlerThread();
        Thread1.start();
        Thread2.start();
        Thread3.start();

    }
}
