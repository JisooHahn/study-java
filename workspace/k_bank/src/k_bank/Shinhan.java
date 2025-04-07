package k_bank;

// 잔액검사 시, 재산 반토막
//	Bank 클래스를 상속받는 Shinhan 클래스
public class Shinhan extends Bank{
//	오버라이드로 잔액검사를 수정
	@Override
	public int showBalance() {
//		현재 잔액(money)를 절반으로 설정
		setMoney(getMoney() / 2);
//		부모 클래스의 showBalance 메소드를 호출하여 절반으로 줄어든 잔액을 반환
		return super.showBalance();
	}
}
