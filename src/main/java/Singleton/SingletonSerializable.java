package Singleton;

import java.io.*;

/**
 * Author: hyb
 * Date: Created in 2018/5/15 9:17
 */
public class SingletonSerializable implements Serializable {

    private static final long serialVersionUID = 888L;

    // 内部类
    private static class SingletonSerializableHandler{
        private static final SingletonSerializable singletonSerializable = new SingletonSerializable();
    }

    public static SingletonSerializable getSingletonSerializable(){
        return SingletonSerializableHandler.singletonSerializable;
    }

    protected Object readResolve(){
        System.out.println("调用了这个方法");
        return SingletonSerializableHandler.singletonSerializable;
    }
}

class SaveAndRead{
    public static void main(String[] args) {
        try {
            SingletonSerializable singletonSerializable = SingletonSerializable.getSingletonSerializable();
            FileOutputStream fileOutputStream = new FileOutputStream(new File("1111111.txt"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(singletonSerializable);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println(singletonSerializable.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("1111111.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SingletonSerializable singletonSerializable = (SingletonSerializable) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(singletonSerializable.hashCode());

        }catch (Exception e){

        }

    }
}
