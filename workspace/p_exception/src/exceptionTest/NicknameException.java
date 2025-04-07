package exceptionTest;

// Exception을 상속받으면,
// 사용자 예외는 발생시키는 순간 try ~ catch로 잡아서 처리해야 한다.

// RuntimeException을 사용하면,
// 사용자 예외는 발생시켰을 때 try ~ catch를 강제하지 않는다.
public class NicknameException extends Exception/*RuntimeException*/{
	public NicknameException() {;}
	
	public NicknameException(String message) {
		super(message);
	}
}
