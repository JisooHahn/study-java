package threadTest;

public class Thread1 extends Thread{
	private String data;
	
	public Thread1() {;}

	public Thread1(String data) {
		super();
		this.data = data;
	}

	public Thread1(String data, String name) {
		super(name);
		this.data = data;
	}

	@Override
	public String toString() {
		return "Thread1 [data=" + data + "]";
	}

//	자원
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			
			try {sleep(1000);} catch (InterruptedException e) {;}
		}
	}
	
}
