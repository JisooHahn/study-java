package methodTest;

public class MethodTestReview {
	
//	f(x) = 2x + 1
	// f는 메소드의 이름
	// 이 메소드는 int의 값을 반환한다
	// int x는 메소드의 매개변수이다. x는 정수로, 함수가 호출될 때 값을 받게된다.
	int f(int x) {
		// 메소드가 반환(리턴)할 값을 계산한다. 
		return 2 * x + 1;
	}
	
//  이름, 나이 2개를 입력받아서 전체 정보 출력하는 메소드
	// void는 반환값이 없다. 리턴하지 않는다.
	// 매개변수로 문자열 name이랑 정수 age를 받는다.
	void printInfo(String name, int age) {
		// name과 age가 문자열로 결합되어 출력된다
		System.out.println(name + ", " + age);
	}
	
//  정수 1개를 입력받고 제곱을 구해주는 메소드
	// 정수의 값을 리턴한다.
	int square(int number) {
		// 제곱이니 받은 number를 2번 곱하여 정수로 리턴한다.
		return number * number;
	}
	
	// main 메소드는 실행 프로그램을 만들어주는 메소드.
	// 원래 static 메소드가 일반 메소드보다 먼저 실행되는데, 
	// static 메소드에서 사용하고 싶으면 이렇게 일반 메소드가 소속된 클래스를 static이 감지할 수 있게 할당한다.
	public static void main(String[] args) {
		// MethodTestReview는 클래스명. MethodTestReview 타입의 객체를 참조하게 된다
		// 클래스의 객체를 생성하고, 이를 m이라는 변수에 할당하는 코드이다.
		// m은 나중에 MethodTestReview 클래스의 메소드나 필드등을 사용할 때 쓰인다.
		MethodTestReview m = new MethodTestReview();	
		int result = 0;
		
		m.f(10);
		m.printInfo("한지수", 20);
		// square 메소드의 매개변수로 정수를 넣고
		// 리턴받은 결과를 result라는 변수에 담는다.
		result = m.square(3);
		// result로 결과 출력
		System.out.println(result);
	}
}
