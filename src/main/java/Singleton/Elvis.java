package Singleton;
  
public class Elvis  
{  
    private static boolean flag = false;  
  
    private Elvis(){  
    }  
  
    private  static class SingletonHolder{  
        private static final Elvis INSTANCE = new Elvis();  
    }  
  
    public static Elvis getInstance()  
    {  
        return SingletonHolder.INSTANCE;  
    }  
  
    public void doSomethingElse()  
    {  
  
    }  
}