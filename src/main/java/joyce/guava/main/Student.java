package joyce.guava.main;

/**
 * 学生实体类
 * 
 * @author Joyce.Luo
 * @date 2014-6-19 下午02:37:19
 */
public class Student {
	/**
	 * 学号
	 */
	private Integer stuId;
	/**
	 * 姓名
	 */
	private String stuName;
	/**
	 * 年龄
	 */
	private Integer stuAge;

	/**
	 * @return the stuId
	 */
	public Integer getStuId() {
		return stuId;
	}

	/**
	 * @param stuId
	 *            the stuId to set
	 */
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	/**
	 * @return the stuName
	 */
	public String getStuName() {
		return stuName;
	}

	/**
	 * @param stuName
	 *            the stuName to set
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * @return the stuAge
	 */
	public Integer getStuAge() {
		return stuAge;
	}

	/**
	 * @param stuAge
	 *            the stuAge to set
	 */
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

	/**
	 * 
	 */
	public Student() {
		super();
	}

	/**
	 * @param stuId
	 * @param stuName
	 * @param stuAge
	 */
	public Student(Integer stuId, String stuName, Integer stuAge) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
}
