package Singleton;

import java.lang.reflect.Constructor;

public class SingetonTest {

	private static SingetonTest singleton = null;
	private int s = 0;
	
	// 构造方法是私有的
//	private SingetonTest(){}
	private static boolean flag = true;

	// 构造方法是私有的
	private SingetonTest(){
		if(flag){
			System.out.println(flag);
			flag = !flag;
		}
		else{
			System.out.println(flag);
			try {
				throw new Exception("duplicate instance create error!" + SingetonTest.class.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 同步的获取实例方法
	public static synchronized SingetonTest getInstance(){
		// 懒汉模式的单例方法
		if(null == singleton){
			synchronized (SingetonTest.class){
				if(singleton == null){
					singleton = new SingetonTest();
				}
			}
		}
		return singleton;
	}
	
	
	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Constructor con = SingetonTest.class.getDeclaredConstructor();
			con.setAccessible(true);
			// 通过反射获取实例
//			SingetonTest singetonTest1 = (SingetonTest)con.newInstance();
			SingetonTest singetonTest2 = (SingetonTest)con.newInstance();
			// 常规方法获取实例
			SingetonTest singetonTest3 = SingetonTest.getInstance();
//			SingetonTest singetonTest4 = SingetonTest.getInstance();
			// 测试输出
//			System.out.println("singetonTest1.equals(singetonTest2) :" +  singetonTest1.equals(singetonTest2));
//			System.out.println("singetonTest3.equals(singetonTest4) :" +  singetonTest3.equals(singetonTest4));
//			System.out.println("singetonTest1.equals(singetonTest3) :" +  singetonTest1.equals(singetonTest3));
//			singetonTest1.setS(1);
//			singetonTest2.setS(2);
//			singetonTest3.setS(3);
//			singetonTest4.setS(4);
//			System.out.println("1:" + singetonTest1.getS() + "  2:" + singetonTest2.getS()+ "  3:" + singetonTest3.getS()+ "  4:" + singetonTest4.getS());
//			System.out.println("1:" + singetonTest1.getS() + "  2:" + " "+ "  3:" + singetonTest3.getS()+ "  4:" + singetonTest4.getS());
//			System.out.println("1:" + singetonTest1.getS());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
