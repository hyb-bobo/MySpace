package Java多线程核心技术;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 10:43
 */
public class MyOneList {
    private List list = new ArrayList();
    synchronized public void add(String data){
        list.add(data);
    }

    synchronized public int getSize(){
        return list.size();
    }
}
