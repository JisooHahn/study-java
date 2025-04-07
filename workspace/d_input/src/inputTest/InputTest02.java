package inputTest;

import java.util.Scanner;

public class InputTest02 {
	public static void main(String[] args) {
//		두 실수를 입력한 뒤 곱셈 결과 출력
//		소수점 둘 째자리까지 출력하고 next()만 사용한다. 
		
		double number1 = 0.0, number2 = 0.0, result = 0.0;
		String input1 = null, input2 = null;
		String inputMessage = "두 정수를 입력하세요\n예)3.65 7.8";
		String format = "%.2f";
		Scanner scan = new Scanner(System.in);
		
		System.out.println(inputMessage);
		input1 = scan.next();
		input2 = scan.next();
		
		number1 = Double.parseDouble(input1);
		number2 = Double.parseDouble(input2);
		result = number1 * number2;
		
//		System.out.printf(format, result);
		result = Double.parseDouble(String.format(format, result));
		
		System.out.println(result);
		
//		1. 입력받은 문자열을 담아줄 변수 2개 선언하기
//		2. 실수형으로 변수 2개 선언하기
//		3. 결과를 담을 실수형 변수 1개 선언하기
//		4. 두 정수를 입력하세요: 메세지 문자열 변수에 담기
//		5. Scanner 자료형의 변수 선언하기
//		6. 메세지 출력하기
//		7. 입력받은 문자열 값을 변수에 저장하기
//		8. 두 문자열을 실수로 형변환하기(Double.parseDouble(""))
//		9. 두 실수를 곱해서 변수에 담아주기
//		10. 결과 출력할 때 printf()를 사용해서 %.2f사용하기
		
		
	}
}













