package castingTest;

public class CastingTest01 {
	public static void main(String[] args) {
//		자동 형변환
		System.out.println(5 / 2);
		System.out.println(5 / 2.0);
		
//		강제 형변환
		System.out.println((double)5 / 2);
		System.out.println((int)2.9 + 5);
		
//		8.43 + 2.59 = 10
		double number1 = 8.43, number2 = 2.59;
		int result = (int)8.43 + (int)2.59;
		
		System.out.println(result);
	}
}













