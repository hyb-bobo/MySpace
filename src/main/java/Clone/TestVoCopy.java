package Clone;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Author: hyb
 * Date: Created in 2018/4/12 15:40
 */
public class TestVoCopy {

    public static void main(String[] args){
        test1();
        System.out.println("---------------------------------");
        test2();
    }
    public static void test1(){
        TestVo1 t1 = new TestVo1();
        t1.setAge(10);
        t1.setName("刘备");
        t1.setBirthday(new Date());
        System.out.println("t1=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());

        TestVo1 t2 = t1.clone();
        System.out.println("t2=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());

    }

    public static void test2(){
        TestVo1 t1 = new TestVo1();
        t1.setAge(10);
        t1.setName("刘备");
        t1.setBirthday(new Date());
        System.out.println("t1=="+t1.getAge()+","+t1.getName()+","+t1.getBirthday());

        TestVo1 t2 = new TestVo1();
        try {
            BeanUtils.copyProperties(t2, t1);
            System.out.println("t2=="+t2.getAge()+","+t2.getName()+","+t2.getBirthday());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
