package Singleton;

import java.io.*;

/**
 * Author: hyb
 * Date: Created in 2018/5/15 11:37
 */
public enum  SingletonMyEnum implements Serializable {

    AAAA;
    private static final long serialVersionUID = 1L;

    private String name;

    public void test() {
        System.out.println("The Test!");
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingletonMyEnum s1 = null;
        SingletonMyEnum s = SingletonMyEnum.AAAA;

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fos = new FileOutputStream("SingletonClass1.obj");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
        } finally {
            oos.flush();
            oos.close();
            fos.close();
        }

        try {
            fis = new FileInputStream("SingletonClass1.obj");
            ois = new ObjectInputStream(fis);
            s1 = (SingletonMyEnum) ois.readObject();
        } finally {
            ois.close();
            fis.close();
        }
        System.out.println(s == s1);
    }
}
