package k_bank;

// 출금 시 수수료 30%
//	클래스 Kakao는 Bank 클래스를 상속받는다
public class Kakao extends Bank{
//	오버라이드로 Bank에서 상속받았던 출금 메소드 수정
	@Override
//	출금 메소드
	public void withdraw(int money) {
		money *= 1.3; // 빠지는 금액에 1.3퍼 곱함(수수료 30퍼니까 금액의 130퍼)
		super.withdraw(money); // 수수료가 추가된 금액이 withdraw 메소드에 전달
	}
}
