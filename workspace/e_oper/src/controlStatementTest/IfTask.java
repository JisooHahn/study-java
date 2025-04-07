package controlStatementTest;

import java.util.Scanner;

public class IfTask {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title = "Q. 당신이 좋아하는 색을 선택하세요.";
		String menu = "1.빨간색\n2.노란색\n3.검은색\n4.흰색";
		int choice = 0;
		String redMessage = "불같고 열정적이고 적극적이다.";
		String yellowMessage = "발랄하고 밝고 귀엽고 개성있고 착하다.";
		String blackMessage = "묵묵하고 든든하고 냉철하고 멋지다.";
		String whiteMessage = "천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.";
		String errorMessage = "잘못 입력하셨습니다.";
		String resultMessage = null;

		boolean condition1 = false, condition2 = false, condition3 = false, condition4 = false;

		System.out.println(title);
		System.out.println(menu);

		choice = sc.nextInt();

		condition1 = choice == 1;
		condition2 = choice == 2;
		condition3 = choice == 3;
		condition4 = choice == 4;

		if (condition1) {
			resultMessage = redMessage;
		} else if (condition2) {
			resultMessage = yellowMessage;
		} else if (condition3) {
			resultMessage = blackMessage;
		} else if (condition4) {
			resultMessage = whiteMessage;
		} else {
			resultMessage = errorMessage;
		}
		
		System.out.println(resultMessage);
	}
}












