package operTest;

public class OperTest01 {
	public static void main(String[] args) {
		boolean isTrue = 10 == 11;
		boolean result = isTrue && 10 <= 20;
		
		System.out.println(10 == 11);
		System.out.println(10 > 3);
		System.out.println(isTrue);
		
		System.out.println(result);
		System.out.println(!result);
	}
}
