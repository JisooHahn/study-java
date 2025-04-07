package inputTest;

import java.util.Scanner;

public class InputTest04 {
	public static void main(String[] args) {
//		두 실수의 뺄셈, 셋 째자리까지
//		nextDouble()
		double number1 = 0.0, number2 = 0.0, result = 0.0; 
		String message = "두 실수를 입력하세요.\n예)3.2 154.32", format = "%.3f";
		String resultFormat = "%.2f - %.2f = %.3f";
		Scanner scan = new Scanner(System.in);
		
		System.out.println(message);
		
		number1 = scan.nextDouble();
		number2 = scan.nextDouble();
		
		result = number1 - number2;
		result = Double.parseDouble(String.format(format, result));
		
		System.out.printf(resultFormat, number1, number2, result);
	}
}












