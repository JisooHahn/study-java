package wrapperTest;

public class WrappperTest {
	public static void main(String[] args) {
		
		int data_i = 10;
		
//		boxing
//		기본 자료형을 래퍼 클래스 객체로 변환하는 과정
//		이를 이용해서 기본 자료형을 객체가 필요한 곳에서 사용할 수 있음
//		Integer data_I = new Integer(data_i);
//		Integer data_I = Integer.valueOf(data_i);
		
//		auto boxing
		Integer data_I = data_i;
		
//		unboxing
//		래퍼 클래스 객체가 기본 자료형으로 변환되는 것
//		data_i = data_I.intValue();
		
//		auto unboxing
		data_i = data_I;
	}	
}
	
