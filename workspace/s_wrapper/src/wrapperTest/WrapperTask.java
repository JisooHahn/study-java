package wrapperTest;

public class WrapperTask {
	public static void main(String[] args) {
//		1, 3.56, 'A', false, "ABC"
//		위 5개의 값을 하나의 배열에 모두 담고 출력한다.
//		여러 자료형의 값들이 들어있는 배열
//		기본 자료형이 다 다르므로 클래스 Object로 모두 묶는다.
		Object[] arData = {1, 3.56, 'A', false, "ABC"};	// boxing

//		arData 배열의 현재 요소가 꺼내지고 값이 Object 타입인 변수 data에 저장된다.
		for (Object data: arData) {
			System.out.println(data);
		}
	}
}
