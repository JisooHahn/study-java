package inputTest;

import java.util.Scanner;

public class InputTest01 {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		String firstName = null, lastName = null;
//		String nameMessage = "이름: ";
//		
//		System.out.print(nameMessage);
		// 공백을 구분점으로 나누어서 각 next에 순서대로 들어간다.
//		lastName = scan.next();
//		firstName =scan.next();
		
//		System.out.println(lastName + firstName + "님 환영합니다.");
		
		Scanner scan = new Scanner(System.in);
		String name = null;
		
		// 출력할 메세지 작성(사용자에게 정확히 원하는 값을 입력받도록 작성)
		System.out.print("이름: ");
		// 입력 상태에 돌입하고, 입력한 값을 문자열로 리턴한다.
//		name = scan.next();
		name = scan.nextLine();
		System.out.println(name + "님 환영합니다!");
	}
}














