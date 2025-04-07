package inputTest;

import java.util.Scanner;

public class InputTest03 {
	public static void main(String[] args) {
//		3개의 정수를 한 번에 입력받은 후 덧셈 결과 출력
//		nextInt(): 사용자가 입력한 정수
		int number1 = 0, number2 = 0, number3 = 0, result = 0;
		String numberMessage = "정수 3개를 입력하세요\n예)4 7 2";
		Scanner scan = new Scanner(System.in);
		
		System.out.println(numberMessage);
		
		number1 = scan.nextInt();
		number2 = scan.nextInt();
		number3 = scan.nextInt();
		
//		System.out.println(number1);
//		System.out.println(number2);
//		System.out.println(number3);
		
		result = number1 + number2 + number3;
		
		System.out.println(result);
		
	}
}












