package MySpace;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: hyb
 * Date: Created in 2018/4/8 16:59
 */
public class A3 {
    public static int plus(int i){
        try {
            ++i;
            return i++;
        }finally {
            i++;
        }
    }

    public static int plus1(int i){
        try {
            ++i;
        }finally {
            return i++;
        }
    }
    public static void main(String[] args){
//        int plus = plus(5);
//        System.out.println(plus);

        String[] id1 = {"1111","aaaa","ddddd"};
        List<String> id2 = new ArrayList<String>();
        id2.add("aaaa");
        id2.add("1111");
        id2.add("ddddd");

        if (id2.containsAll(getArrList(id1)))
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }


    }

    private static List<String> getArrList(String[] arr) {
        List<String> list = new ArrayList<String>();
        for(String col : arr) {
            list.add(col);
        }
        return list;
    }


}
