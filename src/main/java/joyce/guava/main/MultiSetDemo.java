package joyce.guava.main;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

/**
 * Multiset可统计一个词在文档中出现了多少次
 */
public class MultiSetDemo {
 
    public static void main(String[] args) {
        String article = "北国风光，千里冰封，万里雪飘。" +
                "望长城内外，惟余莽莽；大河上下，顿失滔滔。" +
                "山舞银蛇，原驰蜡象，欲与天公试比高。" +
                "须晴日，看红装素裹，分外妖娆。" +
                "江山如此多娇，引无数英雄竞折腰。" +
                "惜秦皇汉武，略输文采；唐宗宋祖，稍逊风骚。" +
                "一代天骄，成吉思汗，只识弯弓射大雕。" +
                "俱往矣，数风流人物，还看今朝。";
        Multiset<String> set = LinkedHashMultiset.create();
        set.add("a");
        set.add("a");
        set.add("lucas");
        set.add("lucas");
        set.setCount("a", 5); // 添加或删除指定元素使其在集合中的数量是count
        System.out.println(set);
        System.out.println(set.count("a")); // 给定元素在Multiset中的计数
        System.out.println(set.size()); // 所有元素计数的总和,包括重复元素
        System.out.println(set.elementSet().size()); // 所有元素计数的总和,不包括重复元素
        set.clear(); // 清空集合
        System.out.println(set);
 
    }


 
}