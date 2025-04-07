package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
//		각자가 각자의 자원에 접근한다.
//		Thread1 thread1 = new Thread1("?", "쓰레드1");
//		Thread1 thread2 = new Thread1("!", "쓰레드2");
//		
//		System.out.println(thread1.getName());
//		System.out.println(thread2.getName());
//		
////		단일
////		thread1.run();
////		thread2.run();
//		
////		멀티
//		thread1.start();
//		thread2.start();
//		
//		System.out.println("메인 쓰레드 종료");
		
//		각 쓰레드는 하나의 자원을 공유한다.
		Thread2 resource = new Thread2();
		
		Thread thread1 = new Thread(resource, "★");
		Thread thread2 = new Thread(resource, "♥");
		
		thread1.start();
		
		try {thread1.join();} catch (InterruptedException e) {;}
		thread1.interrupt();
		
		thread2.start();
		thread2.interrupt();
	}
}
