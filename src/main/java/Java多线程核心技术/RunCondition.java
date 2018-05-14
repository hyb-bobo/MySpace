package Java多线程核心技术;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.collect.*;
import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: hyb
 * Date: Created in 2018/5/8 10:31
 */
public class RunCondition {
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();
    
    public static void main(String[] args){
        /*Thread threadA = new Thread(){
            @Override
            public void run() {

            }
        };*/
        /*List<String> list = new ArrayList() {
            {
                add("组长1");
                add("组长2");
                add("组长3");
//                add("组长1");
            }
        };
        long count = list.stream().distinct().count();
        boolean isRepeat = count < list.size();
        System.out.println(count);//输出2
        System.out.println(isRepeat);//输出true*/

        /*List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println(count);*/

        /*ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        for (int i=0;i<iList.size();i++){
            System.out.println(iList.get(i));
        }*/

/*
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        map.put("aa", list);
        System.out.println(map.get("aa"));//[1, 2]

        Multimap<String,Integer> map1 = ArrayListMultimap.create();
        map1.put("aa", 1);
        map1.put("aa", 2);
        System.out.println(map.get("aa")); //[1, 2]*/



//use java
        /*List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String str = "";
        for(int i=0; i<list.size(); i++){
            str = str + "-" +list.get(i);
        }
        System.out.println(str);*/
//str 为-aa-bb-cc
//use guava
        /*List<String> list1 = new ArrayList<String>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        String result = Joiner.on("-").join(list1);
        System.out.println(result);*/
//result为 aa-bb-cc

       /* Map<String, Integer> map = Maps.newHashMap();
        map.put("xiaoming", 12);
        map.put("xiaohong",13);
        String result = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(result);*/

        //use java
 /*       List<String> list = new ArrayList<String>();
        String a = "1-2-3-4-5-6";
        String[] strs = a.split("-");
        for(int i=0; i<strs.length; i++){
            list.add(strs[i]);
        }*/
//use guava
/*        String str = "1-2-3-4-5-6";
        List<String> list1 = Splitter.on("-").splitToList(str);
        System.out.println(list1.toString());*/
//list为 [1, 2, 3, 4, 5, 6]
        getMethod3();

    }

    public static void  getMethod1(){
        String str = "1-2-3-4- 5- 6 ";
        List<String> list = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str);
        System.out.println(list);
    }
    public static void  getMethod2(){
        String str = "xiaoming=11,xiaohong=23";
        Map<String,String> map = Splitter.on(",").withKeyValueSeparator("=").split(str);
        System.out.println(map);
    }
    public static void  getMethod3(){
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0; i<10000000; i++){
        }
        long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(nanos);
    }

    public static void getMethod4() {
        /*File file = new File("/test.txt");
        List<String> list = null;
        try {
            list = Files.readLines(file, Charsets.UTF_8);
        } catch (Exception e) {
        }
//        Files.copy(from,to); //复制文件
        Files.deleteDirectoryContents(file); //删除文件夹下的内容(包括文件与子文件夹)
        Files.deleteRecursively(File file); //删除文件或者文件夹
        Files.move(File from, File to); //移动文件*/
        URL url = Resources.getResource("abc.xml"); //获取classpath根下的abc.xml文件url

    }




}

class F{
    volatile public static int nextPrintWho = 1;
}

