package inhTest;

// 부모 클래스 Animal 생성
class Animal {
	// Animal의 필드 정의
   String name;
   int age;
   String feed;

   // 자식에서는 항상 super()라는 부모의 기본 생성자를 호출하기 때문에
   // 앞으로는 기본 생성자를 필수적으로 만들어놓자!
   
   // 요 부분이 어려워서 기본 생성자에 대한 이유를 조금 더 찾아봤음
   // 1. 자식 클래스의 객체 생성 시 부모의 객체가 먼저 생성된다
   // 2. 부모 클래스에 기본 생성자가 없으면 super()를 부를 때 문제가 생긴다
   public Animal() {;}
   
   // 매개변수 3개를 받는 생성자(name, age, feed)를 초기화함
   public Animal(String name, int age, String feed) {
      super();
      this.name = name;
      this.age = age;
      this.feed = feed;
   }
   // 메소드들 정의
   // 걷기
   void walk() {
      System.out.println("걷기");
   }
   // 뛰기
   void run() {
      System.out.println("뛰기");
   }
   // 먹기
   void eat() {
      System.out.println("먹기");
   }
}

// 부모 클래스 Animal을 상속받는 클래스 Lion 생성
class Lion extends Animal {
	// Lion 클래스의 기본 생성자
   public Lion() {;}
   
   // Lion 클래스에 있는 고유 기능(사냥)
   void hunt() {
      System.out.println("사냥 하기");
   }
   
   // 부모 클래스에서 상속받은 walk 메소드를 오버라이딩(재정의)
   // 그냥 새로 만드는게 아니라 부모의 요소를 가져와 수정만 한다는 느낌
   @Override
   void walk() {
      System.out.print("네 발로 ");
      super.walk(); // 부모 클래스의 walk()메소드를 호출
//      System.out.println("네 발로 걷기"); // 이렇게도 쓸 수는 있지만, 부모 메소드로 공통적 동작 표현
   }
}

public class InhTest02 {
   public static void main(String[] args) {
//	   Lion 객체를 생성 (Lion은 Animal 클래스를 상속받고 있으므로 Animal의 필드를 물려받는다)
      Lion lion = new Lion();
      
//      오버라이딩 된 walk()메소드
      lion.walk();
   }
}







