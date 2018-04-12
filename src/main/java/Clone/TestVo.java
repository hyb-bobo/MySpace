package Clone;

import util.DateUtil;

import java.util.Date;

public class TestVo implements Cloneable {

    private String name;
    private int age;
    private Date birthday;

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

    public static void test1(){
        TestVo t1 = new TestVo();
        t1.setAge(10);
        t1.setName("刘备");
        t1.setBirthday(new Date());

        TestVo t2 = new TestVo();
        t2.setAge(t1.getAge());
        t2.setName(t1.getName());
        t2.setBirthday(t1.getBirthday());

        System.out.println("t1=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t2=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());

        t2.setAge(20);
        Date date = new Date();
        date.setTime(151515155515L);
        t2.setBirthday(date);
        System.out.println("t3=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t4=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());
    }

    public static void main(String[] args){
        test1();
        System.out.println("---------------------------------");
        test2();
    }

    public static void test2(){
        TestVo t1 = new TestVo();
        t1.setAge(10);
        t1.setName("刘备");
        t1.setBirthday(new Date());

        TestVo t2 = new TestVo();
        t2.setAge(t1.getAge());
        t2.setName(t1.getName());
        t2.setBirthday(t1.getBirthday());

        System.out.println("t11=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t21=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());

        t2.setAge(20);
        t2.setName("张飞");
        //t2.setBirthday(DateUtil.strToDate("2016-11-11 13:13:13"));
        t2.getBirthday().setTime(1000);
        System.out.println("t12=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t22=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());
    }
}