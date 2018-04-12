package Clone;

import java.util.Date;

public class TestVo1 implements Cloneable {

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

    protected TestVo1 clone() {
        TestVo1 testVo = null;
        try {
            testVo = (TestVo1) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testVo;
    }

    public static void test1(){
        TestVo1 t1 = new TestVo1();
        t1.setAge(10);
        t1.setName("刘备");
        t1.setBirthday(new Date());

        TestVo1 t2 = new TestVo1();
        t2.setAge(t1.getAge());
        t2.setName(t1.getName());
        t2.setBirthday(t1.getBirthday());

        System.out.println("t1=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t2=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());

        t2.setAge(20);
        Date date = new Date();
        date.setTime(151515155515L);
        /**
         * 重点就是在这里  这里对t2的赋值是直接赋值
         */
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
        TestVo1 t1 = new TestVo1();
        t1.setAge(10);
        t1.setName("刘备");
        t1.setBirthday(new Date());

        TestVo1 t2 = new TestVo1();
        t2.setAge(t1.getAge());
        t2.setName(t1.getName());
        t2.setBirthday(t1.getBirthday());

        System.out.println("t11=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t21=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());

        t2.setAge(20);
        t2.setName("张飞");
        //t2.setBirthday(DateUtil.strToDate("2016-11-11 13:13:13"));
        /**
         * 这里的t2是通过get方法获取到里面的属性值进行赋值  而里面的属性值又是属于引用类型 这种修改值的方式就是联动影响到其他地方也使用这个值的地方
         *
         * t2.setBirthday(DateUtil.strToDate("2016-11-11 13:13:13"));这样设置值，t1和t2的引用地址不一样，所有t2修改不会对t1产生影响
         * t2.getBirthday().setTime(1000);这样设置值，t1.getBirthday() == t2.getBirthday()控制台返回true,说明t1和t2的引用同一个地址，所有会相互影响，
         */
        t2.getBirthday().setTime(1000);
        System.out.println("t12=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());
        System.out.println("t22=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());
    }
}