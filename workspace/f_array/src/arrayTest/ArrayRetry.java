package arrayTest;

import java.util.Scanner;

public class ArrayRetry {
	public static void main(String[] args) {
	//  브론즈
	//  1 ~ 10까지 배열에 담고 출력
	  
////		1.크기가 10인 배열을 만든다
//		int[] arData = new int[10];
//		for(int i=0; i<arData.length; i++) {
//			arData[i] = i + 1;
//		}
//		
//		for(int i=0; i<arData.length; i++) {
//			System.out.println(arData[i]);
//		}
//		
//	//  10 ~ 1까지 중 짝수만 배열에 담고 출력
//		
//		// 값이 5개
//		int[] arData = new int[5];
//		for(int i=0; i<arData.length; i++) {
//			arData[i] = 10 - i * 2;
//		}
//		
//		for(int i=0; i<arData.length; i++) {
//			System.out.println(arData[i]);
//		}
	  
//	//  1 ~ 100까지 배열에 담은 후 홀수만 출력
//		int length = 100;
//		int[] arData = new int[length];
//		for(int i=0; i<arData.length; i++) {
//			arData[i] = i + 1;
////			System.out.println(arData[i]);
//		}
//		
//		for(int i=0; i <50; i++) {
//			arData[i] = arData[i * 2];
//			System.out.println(arData[i]);
//		}
		
	//  실버
	  
	//  1 ~ 100까지 배열에 담은 후 짝수의 합 출력
//		int[] arData = new int[100];
//		int total = 0;
//		for(int i=0; i<arData.length; i++) {
//			arData[i] = i + 1;
////			System.out.println(arData[i]);
//		}
//		
//		for(int i=0; i<50; i++) {
//			arData[i] = arData[i*2+1];
//			total += arData[i];
//		}
	  
//	//  A ~ F까지 배열에 담고 출력
//		char[] arData = new char[6];
//		for(int i=0; i<arData.length; i++) {
//			arData[i] = (char)(65 + i);
//			System.out.println(arData[i]);
//		}
	  
	//  A ~ F까지 중 D 제외하고 배열에 담은 후 출력
//		char[] arData = new char[5];
//		for(int i=0; i<arData.length; i++) {
//			// 삼항을 썼던가...
//			arData[i] = (char)(i > 2 ? i + 66 : i + 65);
//			System.out.println(arData[i]);
//		}
//	  
	//  골드
	  
//	//  5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
//		int[] arData = new int[5];
//		int max=0, min=0;
//		Scanner sc = new Scanner(System.in);
//	
//		max = arData[0];
//		min = arData[0];
//		
//		for(int i=0; i<arData.length; i++) {
//			System.out.println(i + 1 + "번째 정수: ");
//			arData[i] = sc.nextInt();
//		}
//		
//		for(int i=0; i<arData.length; i++) {
//			if(max < arData[i]) {
//				max = arData[i];
//			}
//			if(min > arData[i]) {
//				min = arData[i];
//			}
//		}
//		
//		System.out.println("최대값: " + max);
//		System.out.println("최소값: " + min);
	  
	//  다이아
	//  사용자가 칸 수를 입력하고, 그 칸 수만큼 정수를 입력받는다.
	//  입력한 정수들의 평균값을 구한다(소수점 2째자리).
		
		int[] arData = null;
		int length = 0;
		String message = "정수의 개수를 입력해주세요.";
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(message);
		length = sc.nextInt();
		arData = new int[length];
		
		for(int i=0; i<arData.length; i++) {
			System.out.println(i + 1 + "번째 정수: ");
			arData[i] = sc.nextInt();
			sum += arData[i];
		}
		
		double average = sum / length;
		
		System.out.printf("평균값: %.2f\n", average);
	}
}

