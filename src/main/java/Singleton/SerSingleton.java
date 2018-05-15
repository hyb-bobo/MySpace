package Singleton;
  
import org.junit.Test;

import java.io.*;

public class SerSingleton implements Serializable
{


    private static final long serialVersionUID = 1L;
  
    String name;  
  
    private SerSingleton()
    {  
        System.out.println("Singleton is create");  
        name="SerSingleton";  
    }  
  
    private static SerSingleton instance = new SerSingleton();
  
    public static SerSingleton getInstance()  
    {  
        return instance;  
    }  
  
    public static void createString()  
    {  
        System.out.println("createString in Singleton");  
    }

    public static void main(String[] args)throws IOException, ClassNotFoundException  {
        SerSingleton s1= null;
        SerSingleton s = SerSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("SerSingleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("SerSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton)ois.readObject();
        System.out.println(s==s1);
    }

   /* @Test
    public void test() throws IOException, ClassNotFoundException
    {
        SerSingleton s1= null;
        SerSingleton s = SerSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("SerSingleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("SerSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton)ois.readObject();
        System.out.println(s==s1);
    }*/
}


  
