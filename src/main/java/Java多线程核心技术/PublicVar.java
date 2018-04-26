package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/26 14:07
 */
public class PublicVar {
    public String userName = "A";
    public String passWord = "AA";
    synchronized public void setValue(String userName,String passWord){
        try{
            this.userName = userName;
            Thread.sleep(3000);
            this.passWord = passWord;
            System.out.println("setValue method name = "+Thread.currentThread().getName()
            + "  userName = "+userName+"  passWord = "+passWord);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getValue(){
        System.out.println("getValue method name = "
                +Thread.currentThread().getName()+
                "  userName = "+userName+"  passWord = "+passWord);
    }
}
