package joyce.guava.main;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Set;

public class BitMapDemo {
 
    public static void main(String[] args) {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("sina", "sina.com");
        biMap.put("qq", "qq.com");
        biMap.put("sina", "sina.cn"); // 会覆盖原来的value
        /*
         * 在BiMap中,如果你想把键映射到已经存在的值，会抛出IllegalArgumentException异常
         * 如果对特定值,你想要强制替换它的键，请使用 BiMap.forcePut(key, value)
         */
        // 抛出异常java.lang.IllegalArgumentException: value already present: qq.com
//        biMap.put("tecent", "qq.com");
        biMap.forcePut("tecent", "qq.com"); // 强制替换key
        System.out.println(biMap);
        System.out.println(biMap.inverse()); // 翻转value-key
        System.out.println(biMap.inverse().get("sina.cn")); // 通过value找key
        System.out.println(biMap.inverse().inverse() == biMap); // true
        Set<String> values = biMap.values();
        System.out.println("-----------");
        for (String str : values) {
            System.out.println(str);
        }

    }
 
}