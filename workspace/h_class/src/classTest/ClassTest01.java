package classTest;

class A {
//	전역 변수(Global variable)
//	새로운 new를 만나면 메모리 해제
//	자동 초기화
	int data;
	
	void printData() {
//		지역 변수(Local variable)
//		닫는 중괄호(})를 만나면 메모리 해제
//		직접 초기화
//		int data = 0;
		System.out.println(this);
		System.out.println(this.data);
	}
}

public class ClassTest01 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		
		System.out.println(a1);
		System.out.println(a2);
		
		a1.printData();
		a2.printData();
	}
}
