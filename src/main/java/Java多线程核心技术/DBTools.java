package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/5/4 10:29
 */

/**
 * 目的：创建20个线程 其中10个线程将数据备份到A数据库 另外10个线程将数据备份到B数据库
 * 并且数据库AB之间的数据备份是交叉进行的
 */
public class DBTools {

    volatile private boolean prevIsA = false;
    synchronized public void backupA(){
        try {
            while (prevIsA == true){
                wait();
            }
            for (int i=0;i<5;i++){
                System.out.println("AAAAAA");
            }
            prevIsA = true;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    synchronized public void backupB(){
        try {
            while (prevIsA == false){
                wait();
            }

            for (int i=0;i<5;i++){
                System.out.println("BBBBBB");
            }
            prevIsA = false;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class BackupA extends Thread{
    private DBTools dbTools;
    public BackupA(DBTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}

class BackupB extends Thread{
    private DBTools dbTools;
    public BackupB(DBTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}

class RunDB{
    public static void main(String[] args){
        DBTools dbTools = new DBTools();
        for (int i=0;i<20;i++){
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
        }
    }
}
