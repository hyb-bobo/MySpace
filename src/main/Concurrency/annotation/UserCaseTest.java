package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 解析注解：
 */
public class UserCaseTest {

    //递归
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        } else {
            return reverse(originStr.substring(1)) + originStr.charAt(0);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);

        /*String s = "sfghj";
        System.out.println(reverse(s));
        StringBuilder b = new StringBuilder(s);
        System.out.print(b.reverse().toString());*/
    }

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            //获得注解的对象
            UseCase.UseCases uc = m.getAnnotation(UseCase.UseCases.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " "
                        + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }
}