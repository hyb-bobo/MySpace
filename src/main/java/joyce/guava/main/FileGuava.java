/**
 * @Description: 
 *
 * @Title: FileGuava.java
 * @Package com.joyce.guava.main
 * @Copyright: Copyright (c) 2014
 *
 * @author Comsys-LZP
 * @date 2014-6-26 下午01:18:18
 * @version V2.0
 */
package joyce.guava.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.io.Files;

/**
 * @Description:Guava的文件
 * 
 * @ClassName: FileGuava
 * @Copyright: Copyright (c) 2014
 * 
 * @author Comsys-LZP
 * @date 2014-6-26 下午01:18:18
 * @version V2.0
 */
public class FileGuava {
	public static void main(String[] args) {
		/*try {
			File readFile = new File(System.getProperty("user.dir") + "/src/resources/showarp.txt");
			StringBuilder content = new StringBuilder();
			if (readFile.exists()) {
				List<String> lines = readFile(readFile);
				for (String string : lines) {
					System.out.println(string);
					content.append(string + "\n");
				}
			}
			File writeFile = new File(System.getProperty("user.dir") + "/src/resources/showarp" + new SimpleDateFormat("yyyyMMdd").format(new Date())+ ".txt");
			writeFile(content.toString(), writeFile);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		/*String method = getMethod1();

		System.out.println(method);

		String[] split = "foo, bar,,   qux,".split(",");
		System.out.println(split.toString());*/
		boolean method2 = getMethod2("2222");
		System.out.println(method2);
	}

	private static String getMethod(){
//		Joiner joiner = Joiner.on("; ").skipNulls();
		Joiner joiner = Joiner.on("; ");
// returns "Harry; Ron; Hermione
//		return joiner.join("Harry", null, "Ron", "Hermione");
		return joiner.useForNull("--").join("Harry", null, "Ron", "Hermione");
	}

	private static String getMethod1(){
		Iterable<String> split = Splitter.on(',').split("foo, bar,,   qux,");
		return split.toString();
	}

	private static boolean getMethod2(String res){
		boolean invalid = Strings.isNullOrEmpty(res);
		return invalid;
	}

	/**
	 * @Description: Guava文件读取
	 * 
	 * @param file
	 * @return
	 * 
	 * @Title: FileGuava.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午01:20:50
	 * @version V2.0
	 */
	private static List<String> readFile(File file) throws Exception {
		if (!file.exists()) {
			return null;
		}
		return Files.readLines(file, Charsets.UTF_8);
	}
	
	/**
	 * @Description: 从文件中获取有规则的数据 
	 *
	 * @param file
	 * @return
	 *
	 * @Title: FileGuava.java
	 * @Copyright: Copyright (c) 2014
	 *
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午01:56:42
	 * @version V2.0
	 */
	public List<String[]> readFileData(File file) throws Exception {
		List<String[]> list = new ArrayList<String[]>();
		for (String rLine : readFile(file)) {
			list.add(rLine.split("\\s+"));
		}
		return list;
	}

	/**
	 * @Description: Guava写文件
	 * 
	 * @param content
	 * @param file
	 * 
	 * @Title: FileGuava.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午01:32:06
	 * @version V2.0
	 */
	private static void writeFile(String content, File file) throws Exception {
		if (!file.exists()) {
			file.createNewFile();
		}
		Files.write(content, file, Charsets.UTF_8);
	}
}
