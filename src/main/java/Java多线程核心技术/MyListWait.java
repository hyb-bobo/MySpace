package Java多线程核心技术;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

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

    public static void main(String[] args){
        String s = new String("");
        System.out.println("程序外");
        synchronized (s){
            System.out.println("程序内,wait前");
            try {
                s.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("程序内,wait后");
        }
    }
}
