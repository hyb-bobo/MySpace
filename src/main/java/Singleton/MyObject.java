package Singleton;

/**
 * Author: hyb
 * Date: Created in 2018/5/15 11:48
 */
public enum MyObject {
    connectionFactory;
    private MyObject(){
        try {
            System.out.println("构造函数被调用");
            String url = "jdbc:";
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

