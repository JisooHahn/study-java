package arrayTest;

import java.util.Scanner;

public class ArrayReview02 {
	public static void main(String[] args) {
		// 건물주가 각 집의 월세를 입력받고, 그 값을 출력하는 프로그램(나도 건물주 하고싶다..)
		
		// 세입자가 3명이고, 월세는 아직 모르기 때문에 배열의 크기를 3으로 설정한다.
		// 여기엔 3개의 집에 대한 월세정보를 저장할 배열이다. 초기값은 0
		int[] arPay = new int[3];
		// 사용자로부터 입력을 받기 위해 객체 scan 생성
		Scanner scan = new Scanner(System.in);
		
		// arPay 배열의 길이 3만큼 반복. i는 0~2까지 반복
		for(int i=0; i<arPay.length; i++) {
			// 1번 집 월세: 2번 집 월세: 같은 방식으로 출력된다
			// 실제 배열은 0번부터지만, 1번 집부터 출력하고 싶기 때문에 값에 1을 더해서 출력한다
			System.out.println(i + 1 + "번 집 월세: ");
			// 사용자가 입력한 값을 arPay의 배열 값으로 저장
			arPay[i] = scan.nextInt();
		}
		
		for (int i=0; i<arPay.length; i++) {
			// 각 방의 월세를 출력한다. 1번 방 월세: 500만원 처럼 표시된다.
			// arPay[i]는 사용자가 입력한 정수 3개이기 때문에 수치는 그대로 뜸
			// 콘솔창에서 각 방의 월세를 3번 입력하면 그에 맞게 결과가 출력됨
 			System.out.println(i + 1 + "번 방 월세: " + arPay[i] + "만원");
		}
		
	}
}
