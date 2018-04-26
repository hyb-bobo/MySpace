package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 14:12
 */
public class ThreadPublicVar extends Thread {
    private PublicVar publicVar;

    public ThreadPublicVar(PublicVar publicVar){
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }

    public static void main(String[] args)  {
        try {
            PublicVar publicVar = new PublicVar();
            ThreadPublicVar threadPublicVar = new ThreadPublicVar(publicVar);
            threadPublicVar.start();
//            Thread.sleep(20000);
            Thread.sleep(200);
            publicVar.getValue();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
