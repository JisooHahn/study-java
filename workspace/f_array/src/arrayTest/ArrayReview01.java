package arrayTest;
//	ArrayReview01이란 클래스 안에
public class ArrayReview01 {
//	main이라는 메소드가 들어있다.
	public static void main(String[] args) {
		//정수(int)형 배열 arData를 선언
		// 배열의 값을 2, 4, 5, 6, 8로 설정
		int[] arData = {2, 4, 5, 6, 8};
		
		// 일케 쓰면 배열 안의 값이 아닌 주소가 뜬다.
		System.out.println(arData);
		// arData의 첫 번째 값 2 출력
		System.out.println(arData[0]);
		// 배열명 뒤에 .length를 쓰면 배열의 길이를 출력한다. 이 배열에는 5개의 요소가 있으므로 length도 5
		System.out.println(arData.length);
		
		// 배열을 순차적으로 출력하기 위하여 for문을 쓴다.
		
		// 조건문에 length를 썼으니 배열의 크기만큼 반복하여 인덱스의 값을 출력한다.
		// length가 아닌 상수를 쓰면 배열의 값의 개수 등이 변화할 때 일일히 수정해야 되는게 귀찮다.
		for(int i = 0; i < arData.length; i++) {
			
			//[0, 1, 2, 3, 4]라는 배열 안의 값이 출력된다. 
			System.out.println(arData[i]);
		}
		
		for(int i = 0; i < arData.length; i++) {
			// 배열 arData의 각 요소를 i로 변경한다. arData[0]은 0, arData[1]은 1 등으로 설정
			// 배열의 값이 {0, 1, 2, 3, 4}로 변경된다
			arData[i] = i;
		}
		
		for(int i = 0; i < arData.length; i++) {
			// 배열이 변경된 후에 모든 값을 출력한다.
			// 0, 1, 2, 3, 4가 출력된다.
			System.out.println(arData[i]);
		}
		
		// arNumber 배열의 크기는 5고, 값은 뭐가 들어갈지 모른다.
		// 초기화된 값은 0이다.
		int[] arNumber = new int[5];
		
		for(int i = 0; i < arNumber.length; i++) {
			arNumber[i] = 5 - i;
			// 배열의 각 요소에 5 - i 값을 저장함.
			// arNumber[0] = 5 - 0 = 5
			// arNumber[1] = 5 - 1 = 4
			// 이런 식으로 배열의 값은 {5, 4, 3, 2, 1}로 설정이 된다.		
		}
		
		for(int i = 0; i < arNumber.length; i++) {
			//같은 메소드 안에 프린트를 넣어도 되지만 모듈화를 위해 메소드는 간결하게 기능따라 나눈다.
			System.out.println(arNumber[i]);
		}	
	}
}
