package joyce.guava.main;

import java.util.Comparator;

/*
 * 使用降序排列
 */
public class SimpleCom implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int a1=o1.length();
        int a2=o2.length();
        if(a1!=a2) {
            return a2-a1;
        }
        if(a1==a2) {
            char[] arr1=o1.toCharArray();
            char[] arr2=o2.toCharArray();
            for(int i=0;i<a1;i++) {
                if(arr1[i]>arr2[i]) {
                    return -1;
                }
                if(arr1[i]<arr2[i]) {
                    return 1;
                }
            }
        }
        return 0;
    }

}