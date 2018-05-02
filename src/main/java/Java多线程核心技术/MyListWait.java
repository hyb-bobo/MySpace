package Java多线程核心技术;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: hyb
 * Date: Created in 2018/5/2 14:25
 */
public class MyListWait {

    private List list = new ArrayList();
    public void add(){
        list.add("中恒");
    }

    public int size(){
        return list.size();
    }

}
