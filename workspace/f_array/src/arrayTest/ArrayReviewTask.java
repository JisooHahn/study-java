package arrayTest;

import java.util.Scanner;

public class ArrayReviewTask {
	public static void main(String[] args) {
//      브론즈
////      1 ~ 10까지 배열에 담고 출력
//		// 값이 10개라는 것을 알기 때문에 배열의 크기를 10으로 선언한다.
//		// arData는 정수형 배열이다.
//		int[] arData = new int[10];
//		for (int i = 0; i < arData.length; i++) {	// 배열의 크기만큼 반복
//			// i가 0부터 시작하지만, 1부터 설정할거라 i + 1을 쓴다
//			arData[i] = i + 1;	// i + 1의 값을 배열에 저장(1 ~ 10)
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i] + " ");	// 배열의 값 출력, 그냥 쓰면 붙어나오니까 공백으로 띄워놓았음
//		}
//		
////      10 ~ 1까지 중 짝수만 배열에 담고 출력
//		
//		// 짝수만 담을거니까 값은 5개{10, 8, 6, 4, 2}
//		int[] arData = new int[5]; // 배열 크기 5로 설정
//		
//		for(int i = 0; i < arData.length; i++) {
//			arData[i] = 10 - (i * 2); //10에서 i*2(0, 2, 4, ...)를 빼서 짝수를 역순으로 저장
//		}
//		
//		// 배열 출력
//		for (int i=0; i<arData.length; i++) {
//			System.out.println(arData[i]); // 배열의 각 요소 한 줄씩 출력
//		}
		
      
////      1 ~ 100까지 배열에 담은 후 홀수만 출력
//		int length = 100; // 값이 100개니까 크기도 100 
//		int[] arData = new int[length]; // 크기 100으로 배열 선언
//		
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1; // 배열에 1 ~ 100까지 담았음(i는 0 ~ 99)
//		}
//		// i가 0~49까지 50번 반복된다
//		for (int i = 0; i < 50; i++) {
//			System.out.println(arData[i * 2]);
//		}
      
//      실버
      
////      1 ~ 100까지 배열에 담은 후 짝수의 합 출력
//		
////		값이 100개 있기 때문에 크기가 100인 배열을 만든다
//		int[] arData = new int[100];
//		// 합을 따로 구할거기 때문에 합을 저장할 total의 초기값 지정
//		int total = 0;
//				
//		for(int i = 0; i < arData.length; i++) {		
//			arData[i] = i + 1;	// arData에 1부터 100까지의 값을 담기
//		}
//		
//		// 짝수만 가지고 올거니까 50번 반복
//		for(int i = 0; i < 50; i++) {
//			// 홀수 인덱스를 참조, arData[1, 3, 5, ...]
//			total += arData[i * 2 + 1];
//		}
      
////      A ~ F까지 배열에 담고 출력
//		
//		char[] arData = new char[6];	//값이 6개니까 크기 6으로 배열 선언, 문자 담을 거니까 char
//		
//		for(int i = 0; i < arData.length; i++) {	// 반복은 6번 함
//			// 65는 아스키 코드에서 'A'의 값
//			arData[i] = (char)(65 + i); 
//		}
//		
//		for(int i = 0; i < arData.length; i++	System.out.println(arData[i]);	//) {
//		 결과 출력
//		}
      
////      A ~ F까지 중 D 제외하고 배열에 담은 후 출력
//		char[] arData = new char[5];	// D 제외할거니까 크기는 5
//		
//		for(int i = 0; i < arData.length; i++) {
//			//  arData[2]보다 큰 값은 D부터이므로, D부터 1씩 더해서 D를 건너뛴다
//			arData[i] = (char)(i > 2 ? i + 66 : i + 65);
//		}
//		
//		for(int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
      
//      골드
      
////      5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
//		int[] arData = new int[5]; // 크기는 5로
//		// 최대값과 최소값을 담을 변수 선언, 0으로 초기화
//		int max = 0, min = 0;
//		Scanner sc = new Scanner(System.in);	// 사용자로부터 입력을 받기 위해 사용
//		
//		// 5번 반복되며, 사용자에게 정수를 5개의 정수를 입력받음
//		// 5번 받으려면 for문 안에서 입력받은 수를 배열에 담아야함
//		for(int i = 0; i < arData.length; i++) {
//			System.out.println(i + 1 + "번 정수: ");
//			arData[i] = sc.nextInt();	// 입력받은 정수 arData[i]에 저장
//		}
//		
//		// 배열의 첫 번째 요소인 arData[0]을 max와 min의 초기값으로 설정
//		// arData의 첫 번째 기준으로 시작하면, 배열을 순차적으로 등록하면서 최대값 최소값을 업데이트할 수 있다.
//		max = arData[0];
//		min = arData[0];
//		
//		for (int i = 0; i < arData.length; i++) {
//			// max가 arData보다 작다면, 
//			if (max < arData[i]) {
//				// max를 arData[i]의 값으로 업데이트
//				max = arData[i];
//			}
//			// min이 arData보다 크다면,
//			if (min > arData[i]) {
//				// min을 arData[i]의 값으로 업데이트
//				min = arData[i];
//			}
//		}
//		
//		System.out.println("최대값: " + max);
//		System.out.println("최소값: " + min);
		
//      다이아
//      사용자가 칸 수를 입력하고, 그 칸 수만큼 정수를 입력받는다.
//      입력한 정수들의 평균값을 구한다(소수점 2째자리).
		
		// 평균값을 어케 구하냐? 정수들을 다 더 해서 정수의 개수로 나누면 된다
		// 일단 하던대로 반복문을 돌려서 결과를 다 더하면 될 것 같다
		
		int[] arData = null;
		// 사용자가 칸 수를 입력하기 때문에 배열의 크기를 입력받은 값으로 정한다.
		// length를 선언해놓자
		int length = 0;
		// 숫자의 합을 담을 변수
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		String message = "정수 개수: ";
		
		System.out.println(message);
		// 사용자한테 배열의 크기 입력받기
		length = sc.nextInt();
		
		arData = new int[length];
		
		for(int i = 0; i < arData.length; i++) {
			// i + 1을 출력해보면 i만큼 반복한다.
			System.out.println(i + 1 + "번째 정수: ");
			// 칸 수 만큼 정수도 입력받아야한다
			arData[i] = sc.nextInt();
			sum += arData[i];	// 입력받은 정수를 합산
		}
		
		// 이제 입력한 정수들의 평균을 구해야한다.
		// 소숫점까지 출력할거니까 int 말고 double로
		double average = (double) sum / length;
		
		// 소숫점 두 자리까지 출력(%.2f\n)
		// format를 사용할거니까 println이 아니라 printf
		System.out.printf("입력한 정수들의 평균값: %.2f\n", average);
	}
}
