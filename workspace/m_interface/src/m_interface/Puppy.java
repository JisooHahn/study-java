package m_interface;

public class Puppy implements Animal{

	@Override
	public void showHands() {
		System.out.println("멍!");
	}

	@Override
	public void sitDown() {
		System.out.println("멍!");
	}

	@Override
	public void poop() {
		System.out.println("머엉...");
	}

	@Override
	public void waitNow() {
		System.out.println("멍!");
	}

}
