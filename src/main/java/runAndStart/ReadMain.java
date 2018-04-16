package runAndStart;

public class ReadMain {
    public static void main(String[] args){
		Student1 s1 = new Student1();
		s1.setName("线程1"); //为线程命名
		
		Student2 s2 = new Student2();
		s2.setName("线程2"); //为线程命名
		System.out.println("主线程名:"+Thread.currentThread().getName()+"--线程id:"+Thread.currentThread().getId());
//		s1.start();
		s1.run();
//		s2.start();
		s2.run();
	}
}