package k_bank;

//	입금 시 수수료 30%
//  Bank 클래스를 상속받는 Kookmin 클래스
public class Kookmin extends Bank{
//	입금 메소드 오버라이드로 수정
	@Override
//	입금 메소드
	public void deposit(int money) {
		money *= 0.7; // 입금 되는 금액-30%(전체 금액에서 70퍼 곱하기)
		super.deposit(money); // 수수료가 포함된 금액이 deposit 메소드에 전달
	}
}
