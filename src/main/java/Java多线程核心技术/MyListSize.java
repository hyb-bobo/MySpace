package Java多线程核心技术;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: hyb
 * Date: Created in 2018/5/3 9:01
 */
public class MyListSize {

    private static List list = new ArrayList();
    public static void add(){
        list.add("XXXXX");
    }

    public static int size(){
        return list.size();
    }
}
