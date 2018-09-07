package joyce.guava.main;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class ImmutableDemo {
    public static void main(String[] args) {
        ImmutableSet<String> set = ImmutableSet.of("a", "b", "c", "d");
        ImmutableSet<String> set1 = ImmutableSet.copyOf(set);
        ImmutableSet<String> set2 = ImmutableSet.<String> builder().addAll(set).add("e").build();
        ImmutableList<String> list = set2.asList();
         
        System.out.println("set:"+set);
        System.out.println("set1:"+set1);
        System.out.println("set2:"+set2);
        System.out.println("list:"+list);
        //set.add("f");//java.lang.UnsupportedOperationException
    }
}