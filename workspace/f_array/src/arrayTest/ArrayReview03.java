package arrayTest;

public class ArrayReview03 {
	public static void main(String[] args) {
		// 이것은 2차원 배열이다. 대충 배열의 값 안에 배열이 들어간 느낌같다.
		// 배열의 관리를 더 쉽게 하기 위해 사용하지만, 메모리 낭비가 심하다. 
		// 사용하진 않아도 보고 해석은 가능해야 한다고 한다
		
		// 앞의 괄호가 행, 뒤의 괄호가 열의 값이라고 생각하자
		// 여기서 윗 줄이 3, 5, 2 아랫 줄이 21, 54, 43이니까 2행 3열이다
		int[][] arrData = {{ 3, 5, 2 },{ 21, 54, 43 }};
		
		// arrData.length는 행의 길이, arrData[행].length는 열의 길이
		// 행 먼저, 다음에 열이다
		for (int i = 0; i < arrData.length; i++) {
			// for을 2중으로 쓰고 다음 변수 j를 사용했다
			// 열 부분이기 때문에 행의 변수인 i를 넣어 arrData[i].length로 열의 길이다
			for (int j = 0; j < arrData[i].length; j++) {
				// 배열의 값들이 한 줄씩 출력됨
				System.out.println(arrData[i][j]);
			}
		}
		
		// 2중 for나 변수 두개는 필요하다 생각하면 사용하는 것이다. 겁내지 말자
		
		// 배열의 행의 개수를 rowLength에 저장. arrData.length는 2이므로 행은 2
		int rowLength = arrData.length;
		// 첫 번째 행의 열 개수를 colLength에 저장. 첫 번째 행은 3, 5, 2이기 때문에 열은 3
		int colLength = arrData[0].length;
		// 배열의 전체 크기를 계산한다. 여기서 행은 2, 열은 3이기 때문에 전체 길이는 2 * 3 = 6
		int length = rowLength * colLength;
		
		// 0부터 length - 1까지 총 6번을 반복 
		for(int i = 0; i < length; i++) {
			// 2차원 배열을 1차원같이 다루는 부분
			// i / 3은 현재의 행, i % 3(i를 3으로 나눈 나머지)은 현재의 열을 결정한다. 
			System.out.println(arrData[i / 3][i % 3] + " ");
			// i가 2일 때마다 줄 바꿈을 출력하여 첫 행이 끝났음을 나타낸다.
			// 아 근데 이렇게 보니까 그냥 for 두 번 쓰는게 더 편해보이네;
			if(i == 2) {
				System.out.println();
			}
		}
	}
}
