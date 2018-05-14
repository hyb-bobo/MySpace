package Stream;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * Author: hyb
 * Date: Created in 2018/5/14 13:34
 */
public class MyStream {
    public static void main(String[] args){

//        long method = getMethod();
//        System.out.println(method);
//
//        Function<String, Object> stringObjectFunction = MyStream.stringObjectFunction;
        getMethod1();

    }


    /**
     * 可见λ表达式有三部分组成：参数列表，箭头（->），以及一个表达式或语句块。
     * @return
     */
    private static long getMethod(){
        //Lists是Guava中的一个工具类
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        long count = nums.stream().filter(num -> num != null).count();
        return count;
    }

    private static void getMethod1(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
        System.out.println(integerStream);
        Stream<String> stringStream = Stream.of("taobao");
        System.out.println(stringStream);

    }


    static Function<String, Object>  stringObjectFunction = (String c) -> {
        return c.length();
    };
}
