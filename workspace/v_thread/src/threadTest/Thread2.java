package threadTest;

//	쓰레드가 아닌 자원
public class Thread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()); 
			
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
	}

}
