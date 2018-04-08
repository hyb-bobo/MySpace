package MySpace;

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
        int plus = plus(5);
        System.out.println(plus);
    }
}
