package ThreadTest;

/**
 * Author: hyb
 * Date: Created in 2018/4/16 14:36
 */
public class Teacher extends Person {
    public void printValue(int i,int j){
        System.out.println("3");
    }

    public void printValue(int i){
        System.out.println("4");
    }

    public static void main(String[] args){
        Person p = new Teacher();
        p.printValue(10);
    }

}
