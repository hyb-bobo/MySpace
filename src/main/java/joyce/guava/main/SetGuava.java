/**
 * @Description: 
 *
 * @Title: SetGuava.java
 * @Package com.joyce.guava.main
 * @Copyright: Copyright (c) 2014
 *
 * @author Comsys-LZP
 * @date 2014-6-26 上午11:03:53
 * @version V2.0
 */
package joyce.guava.main;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Table;

/**
 * @Description: Guava的集合
 * 
 * @ClassName: SetGuava
 * @Copyright: Copyright (c) 2014
 * 
 * @author Comsys-LZP
 * @date 2014-6-26 上午11:03:53
 * @version V2.0
 */
public class SetGuava {
	public static void main(String[] args) {
		/**
		 * Guava API 提供了有用的新的集合类型， 协同已经存在的java集合工作的很好。 分别是 Multimap， Multiset，
		 * Table， BiMap， ClassToInstanceMap
		 */
		System.out.println("Multimap：一种key可以重复的map，子类有ListMultimap和SetMultimap，对应的通过key分别得到list和set");
		testMultimap();
		System.out.println("Multiset：不是集合，可以增加重复的元素，并且可以统计出重复元素的个数");
		testMulitiset();
		System.out.println("Table：相当于有两个key的map");
		testTable();
		System.out.println("BiMap: 是一个一一映射，可以通过key得到value，也可以通过value得到key");
		testBitMap();
		System.out.println("ClassToInstanceMap：map的key并不是只是一种类型");
		testClassToInstanceMap();
		System.out.println("排序，是guava一份非常灵活的比较类，可以被用来操作，扩展，当作比较器，排序提供了集合排序的很多控制 ");
		testOrder();
	}

	/**
	 * @Description: Multimap：一种key可以重复的map，子类有ListMultimap和SetMultimap，对应的通过key分别得到list和set
	 * 
	 * 
	 * @Title: SetGuava.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 上午11:19:50
	 * @version V2.0
	 */
	private static void testMultimap() {
		Multimap<String, Student> customersByType = ArrayListMultimap.create();
		customersByType.put("abc", new Student(1, "Joyce", 20));
		customersByType.put("abc", new Student(1, "Joyce One", 20));
		customersByType.put("abc", new Student(1, "Joyce Two", 20));
		customersByType.put("abc", new Student(1, "Joyce Three", 20));
		customersByType.put("abcd", new Student(1, "Joyce Four", 20));
		customersByType.put("abcde", new Student(1, "Joyce Five", 20));
		System.out.println(customersByType.get("abc").size());
		for (Student stu : customersByType.get("abc")) {
			System.out.println(stu.getStuName());
		}
	}

	/**
	 * @Description: Multiset：不是集合，可以增加重复的元素，并且可以统计出重复元素的个数
	 * 
	 * 
	 * @Title: SetGuava.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 上午11:19:59
	 * @version V2.0
	 */
	private static void testMulitiset() {
		Multiset<Integer> multiSet = HashMultiset.create();
		multiSet.add(10);
		multiSet.add(30);
		multiSet.add(30);
		multiSet.add(40);
		System.out.println(multiSet.count(30)); // 2 -- 统计XX出现的次数
		System.out.println(multiSet.size()); // 4 -- 元素的个数
	}

	/**
	 * @Description: Table：相当于有两个key的map
	 * 
	 * 
	 * @Title: SetGuava.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 上午11:24:43
	 * @version V2.0
	 */
	private static void testTable() {
		Table<Integer, Integer, Student> personTable = HashBasedTable.create();
		personTable.put(1, 20, new Student(1, "46546", 20));
		personTable.put(0, 30, new Student(2, "46546", 30));
		personTable.put(0, 25, new Student(3, "46546", 25));
		personTable.put(1, 50, new Student(4, "46546", 50));
		personTable.put(0, 27, new Student(5, "46546", 27));
		personTable.put(1, 29, new Student(6, "46546", 29));
		personTable.put(0, 38, new Student(7, "46546", 38));
		personTable.put(1, 66, new Student(8, "46546", 66));

		// 得到行集合
		Map<Integer, Student> rowMap = personTable.row(0);
		Integer rowMax = Collections.max(rowMap.keySet());
		System.out.println(rowMax);
	}

	/**
	 * @Description: BiMap: 是一个一一映射，可以通过key得到value，也可以通过value得到key
	 * 
	 * 
	 * @Title: SetGuava.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 上午11:36:59
	 * @version V2.0
	 */
	private static void testBitMap() {
		// 双向map
		BiMap<Integer, String> biMap = HashBiMap.create();
		biMap.put(1, "hello");
		biMap.put(2, "helloa");
		biMap.put(3, "world");
		biMap.put(4, "worldb");
		biMap.put(5, "my");
		biMap.put(6, "myc");
		// 通过key取value
		String value = biMap.get(5);
		System.out.println("key -- [5] ; value -- [" + value + "]");
		// 通过value取key
		Integer key = biMap.inverse().get("my");
		System.out.println("value -- [my] ; key -- [" + key + "]");
	}

	/**
	 * @Description: ClassToInstanceMap：有的时候，你的map的key并不是一种类型，他们是很多类型，你想通过映射他们得到这种类型，
	 *               guava提供了ClassToInstanceMap满足了这个目的。
	 * 
	 *               除了继承自Map接口，ClassToInstaceMap提供了方法 T getInstance(Class<T>) 和
	 *               T putInstance(Class<T>, T),消除了强制类型转换。
	 * 
	 *               该类有一个简单类型的参数，通常称为B，代表了map控制的上层绑定，例如：
	 *               ClassToInstanceMap<Number> numberDefaults =
	 *               MutableClassToInstanceMap.create();
	 *               numberDefaults.putInstance(Integer.class,
	 *               Integer.valueOf(0));
	 * 
	 *               从技术上来说，ClassToInstanceMap<B> 实现了Map<Class<? extends B>,
	 *               B>，或者说，这是一个从B的子类到B对象的映射，这可能使得ClassToInstanceMap的泛型轻度混乱，
	 *               但是只要记住B总是Map的上层绑定类型，通常来说B只是一个对象。 guava提供了有用的实现，
	 *               MutableClassToInstanceMap 和 ImmutableClassToInstanceMap.
	 *               重点：像其他的Map<Class,Object>,ClassToInstanceMap
	 *               含有的原生类型的项目，一个原生类型和他的相应的包装类可以映射到不同的值；
	 * 
	 * 
	 * 
	 * @Title: SetGuava.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 上午11:42:52
	 * @version V2.0
	 */
	private static void testClassToInstanceMap() {
		ClassToInstanceMap<Student> classToInstanceMap = MutableClassToInstanceMap.create();
		Student stu = new Student(1, "Joyce", 20);
		classToInstanceMap.putInstance(Student.class, stu);
		Student stuObj = classToInstanceMap.getInstance(Student.class);
		System.out.println(stuObj.getStuName());
	}
	
	/**
	 * @Description:排序，是guava一份非常灵活的比较类，可以被用来操作，扩展，当作比较器，排序提供了集合排序的很多控制 
	 *
	 *
	 * @Title: SetGuava.java
	 * @Copyright: Copyright (c) 2014
	 *
	 * @author Comsys-LZP
	 * @date 2014-6-26 上午11:49:30
	 * @version V2.0
	 */
	private static void testOrder(){
		List<Integer> numberList = Lists.newArrayList(30, 20, 60, 80, 10);
		System.out.println(Ordering.natural().sortedCopy(numberList)); //10,20,30,60,80
		System.out.println(Ordering.natural().reverse().sortedCopy(numberList)); //80,60,30,20,10
		System.out.println(Ordering.natural().min(numberList));//10
		System.out.println(Ordering.natural().max(numberList));//80
		numberList =  Lists.newArrayList(30, 20, 60, 80, null, 10);
		System.out.println(Ordering.natural().nullsLast().sortedCopy(numberList));//10, 20,30,60,80,null
		System.out.println(Ordering.natural().nullsFirst().sortedCopy(numberList));//null,10,20,30,60,80
	}
}
