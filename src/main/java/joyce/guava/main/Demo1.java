package joyce.guava.main;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<String> list= Lists.newArrayList("hello","world","javab","c","someone");
        Collection<List<String>> collection= Collections2.orderedPermutations(list);
        System.out.println(collection.size());
        for(List<String> temp:collection) {
            System.out.println(temp);
        }

        System.out.println("==============使用比较器=================");
        Collection<List<String>> collection5=Collections2.orderedPermutations(list,new SimpleCom());
        System.out.println(collection5.size());
        for(List<String> temp:collection5) {
            System.out.println(temp);
        }

        System.out.println();
        System.out.println();
        Collection<List<String>> collection2=Collections2.permutations(list);
        for(List<String> temp:collection2) {
            System.out.println(temp);
        }

        Collection<String> collection3=Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.length()>=5?true:false;
            }
        });
        System.out.println();
        for(String temp:collection3) {
            System.out.println(temp);
        }

        Collection<String> collection4=Collections2.transform(collection3, new Function<String, String>() {

            @Override
            public String apply(String input) {
                return input.toUpperCase();
            }
        });
        System.out.println();
        for(String temp:collection4) {
            System.out.println(temp);
        }
        Collections.sort(list);
    }
}