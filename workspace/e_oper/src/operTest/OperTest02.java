package operTest;

import java.util.Scanner;

public class OperTest02 {
	public static void main(String[] args) {
//		두 정수 입력받기
		int number1 = 0, number2 = 0;
		String result = null;
		String message = "두 정수를 입력하세요.\n예)1 6";
		boolean condition1 = false, condition2 = false;
		Scanner scan = new Scanner(System.in);
		
		System.out.println(message);
		number1 = scan.nextInt();
		number2 = scan.nextInt();
		condition1 = number1 > number2;
		condition2 = number1 == number2;
		
		result = condition1 ? "더 큰 값: " + number1 : 
			condition2 ? "두 수가 같습니다." : "더 큰 값: " + number2;
		
		System.out.println(result);
	}
}















