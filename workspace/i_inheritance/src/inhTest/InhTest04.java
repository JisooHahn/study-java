package inhTest;

import java.util.Random;

class Job {
	int money;
	
	public Job() {;}

	public Job(int money) {
		super();
		this.money = money;
	}
}

//직업은 아이돌로
//금액 말고도 명성이 있다.
//공연을 하면 50퍼는 명성의 변동이 없고, 40퍼 확률로 1씩 상승한다.
//10퍼의 확률로 1씩 깎이기도 한다
//받는 금액은 명성이 높아질 수록 많이 받게된다.

class Idol extends Job {
	//	명성
	int fame;
	Random random = new Random();
	
	public Idol() {;}

	public Idol(int money, int fame) {
		super(money);
		this.fame = fame;
	}
	
	// 콘서트(확률) 메소드
	void concert(int money) {
		// 공연 전 상태 출력
		System.out.println("현재 소지 금액: " + money + " 현재 명성: " + fame);
		
		// 확률 배열.... 10중에서 그대로 5, 상승 4, 하락 1
		int[] arData = new int[10]; // 배열 크기: 10
		
		// 범위를 10으로 정하고 랜덤을 돌리면 그 안의 숫자들 중에 하나가 나온다
		
		// 첫 번째 10퍼센트로 하락
		// 일단 경우의 수를 arData의 크기만큼 해놓고 그 안에 if로 확률을 나눈?다?
		for(int i = 0; i < arData.length; i++) {
			// 1. 10퍼 확률로 실패 [0]
			if(i<1) {
				arData[i] = 0;
				// 2. 50퍼 확률로 유지 [1]
			}else if(i<6) {
				arData[i] = 1;
				// 3. 나머지 40퍼 확률로 상승 [2]
			} else {
				arData[i] = 2;
			}
		}
		// 랜덤으로 길이 결정
		int result = arData[random.nextInt(arData.length)];
		
		// 아까 확률대로 설정한 배열의 값 따라 다른 결과 출력 및 명성 수정 
		if(result == 0) { // 실패
			fame--;
			money += fame*2;
			System.out.println("공연 실패! 명성 하락...");
		} else if(result == 1) { // 유지
			money += fame*3;
			System.out.println("그럭저럭 괜찮았다");
		} else { // 성공
			fame++;
			money += fame*4;
			System.out.println("공연 성공! 명성 상승");
		}
		// 이후 결과 출력
		System.out.println("현재 소지 금액: " + money + " 현재 명성: " + fame);
		
	}
}

public class InhTest04 {
	public static void main(String[] args) {
		Idol idol = new Idol(100, 5);// 초기 소지 금액 100, 명성은 5
		//공연 실행
		idol.concert(idol.money);
	}
}
