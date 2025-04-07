package inhTest;

class Hero {
	// 상속시킬 공통 필드
   int hp;
   int dmg;
   
   public Hero() {;}
   
   public Hero(int hp, int dmg) {
      this.hp = hp;
      this.dmg = dmg;
   }

   void getDmg(int dmg) {
      this.hp -= dmg;
   }
   
   int attack() {
      return dmg;
   }
}

class Thor extends Hero {
	// 객체가 따로 쓸 필드
   int hammerCount;
   int shildCount;
   
   public Thor() {;}
   
   public Thor(int hp, int dmg, int hammerCount, int shildCount) {
	   // 부모 hero에게서 hp랑 dmg 상속받음
      super(hp, dmg);
      this.hammerCount = hammerCount;
      this.shildCount = shildCount;
   }

   @Override
   // 데미지를 받는 메소드
   void getDmg(int dmg) {
	   // 쉴드가 0보다 적으면?
      if(shildCount <= 0) {
    	  //데미지를 받는다
         super.getDmg(dmg);
         // 결과 리턴
         return;
      }
      // 받는 데미지에서 보유하는 쉴드만큼 뺀다
      dmg -= shildCount;
      // 쉴드보다 더 들간 데미지를 받는다
      super.getDmg(dmg);
      // 쉴드를 사용하니까 count에서 뺀다
      shildCount--;
   }
   
   @Override
   // 데미지를 주는 메소드
   int attack() {
      int dmg = super.attack();
      // 해머가 0보다 크면?
      if(hammerCount > 0) {
    	  // 해머카운트가 1이면 1의 데미지, 그 이상이면 보유한 해머카운트에 데미지를 더하여 데미지를 계산한다
         dmg = hammerCount == 1 ? dmg + 1 : (dmg * hammerCount);
         // 해머를 사용했으니 보유 해머에서 뺀다
         hammerCount--;
         // 최종 데미지를 리턴한다
         return dmg;
      }
      return dmg;
   }
}

//	원하는 히어로 만들기
//	Hero 클래스를 상속받아서 구현한다.

class Berserker extends Hero {
	int overDrive; // 공격쪽 능력
	int strCount; // 방어쪽 능력
	int finalDmg; // 최종 데미지 저장용
	
	public Berserker() {;}
	
	public Berserker(int hp, int dmg, int overDrive, int strCount) {
		super(hp, dmg);
		this.overDrive = overDrive;
		this.strCount = strCount;
	}
	
	@Override
	void getDmg(int dmg) {
		if(strCount <= 0) {
			int finalDmg = dmg-hp/10;
			super.getDmg(finalDmg);
			return;
		}
		dmg -= strCount;
		int finalDmg = dmg-hp/10;
		super.getDmg(finalDmg);
		strCount--;
		System.out.println("남은 방어력 횟수: " + strCount);
	}
	
	@Override
	int attack() {
		int dmg = super.attack();
		
		if(hp < 10) {
			dmg = 2 * (10-hp);
			overDrive--;
			return dmg;
		}
		return dmg;
	}
}

public class InhTest03 {
   public static void main(String[] args) {
//      Thor thor = new Thor(10, 5, 2, 2);
//      thor.getDmg(10);
      Berserker berserk = new Berserker(8, 5, 4, 2);
//      berserk.getDmg(4);
      
//      System.out.println(thor.hp);
//      System.out.println(thor.shildCount);
//      
//      System.out.println("입힌 데미지: " + thor.attack());
//      System.out.println(thor.hammerCount);
//      System.out.println("입힌 데미지: " + thor.attack());
//      System.out.println(thor.hammerCount);
//      System.out.println("입힌 데미지: " + thor.attack());
//      System.out.println(thor.hammerCount);
//      
      
      System.out.println("현재 체력: " + berserk.hp);
      System.out.println("방어력: " + berserk.strCount);
      
      System.out.println("입힌 데미지: " + berserk.attack());
      System.out.println(berserk.overDrive);
      berserk.getDmg(4);
      System.out.println("받은 데미지: " + berserk.dmg);
      System.out.println("방어력 " + berserk.strCount + "로 데미지 감소, 남은 방어력: " + (berserk.strCount-1) + "\n 남은 hp: " + berserk.hp);
      System.out.println("최종 받은 데미지: " + berserk.finalDmg);
      System.out.println("입힌 데미지: " + berserk.attack());
      System.out.println(berserk.overDrive);
      System.out.println("입힌 데미지: " + berserk.attack());
      System.out.println(berserk.overDrive);
   }
}














