package Singleton;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Author: hyb
 * Date: Created in 2018/5/15 11:48
 */
public enum MyObject {
    connectionFactory;
    private Connection con = null;
    private MyObject(){
        try {
            System.out.println("构造函数被调用");
            String url = "jdbc:mysql://localhost:3306/MySql";
            String username = "root";
            String password = "123456";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(url,username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getCon(){
        return con;
    }

}

class MyThreadSql extends Thread{
    @Override
    public void run() {
        for(int i= 0;i<5;i++){
            System.out.println(MyObject.connectionFactory.getCon().hashCode());
        }
    }
}


class RunSql{

    public static void main(String[] args){
        MyThreadSql myThread1 = new MyThreadSql();
        MyThreadSql myThread2 = new MyThreadSql();
        MyThreadSql myThread3 = new MyThreadSql();
        myThread1.start();
        myThread2.start();
        myThread3.start();

    }
}

