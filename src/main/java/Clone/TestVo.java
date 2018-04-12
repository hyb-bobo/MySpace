package Clone;

import org.junit.Test;
import util.DateUtil;

import java.util.Date;

public class TestVo implements Cloneable {

    private String name;
    private int age;
    private Date birthday;
    TestVoB testVoB = new TestVoB(222);

    public TestVoB getTestVoB() {
        return testVoB;
    }

    public void setTestVoB(TestVoB testVoB) {
        this.testVoB = testVoB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    protected TestVo clone() {
        TestVo testVo = null;
        try {
            testVo = (TestVo) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testVo;
    }

    public static void test2() throws CloneNotSupportedException{
        TestVo t1 = new TestVo();
        t1.setAge(10);
        t1.setName("刘备");
        t1.setBirthday(new Date());

        TestVo t2 = t1.clone();
        System.out.println("t1=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t2=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());

        t2.setAge(20);
        t2.setName("张飞");
        t2.setBirthday(new Date());
        t2.testVoB.sumValue();
        System.out.println("t3=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday()+","+t1.testVoB);
        System.out.println("t4=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday()+","+t2.testVoB);
    }
    
    public static void main(String[] args){
        try {
            test2();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}