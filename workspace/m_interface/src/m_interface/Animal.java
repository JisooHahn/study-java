package m_interface;

public interface Animal {
	final static int eyes = 2;
//	인터페이스는 구현이 안 되고 고정이 되어야하기 때문에
//	이렇게 써도 final static이 생략되어 있다
	int nose = 1;
	
	abstract void showHands();
	void sitDown();
	void poop();
	void waitNow();
}

