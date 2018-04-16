package runAndStart;

public class Student1 extends Thread {
    @Override
	public void run(){		
		System.out.println("线程名:"+Thread.currentThread().getName()+"--线程id:"+Thread.currentThread().getId());		
	}
}