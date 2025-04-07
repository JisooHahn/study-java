package castingTest;

// 부모 클래스 car 생성
class Car {
//	car 클래스의 필드 정의
   String brand; // 브랜드
   String color; // 색깔
   int price; // 가격
   
//   기본 생성자
   public Car() {;}

//   매개변수를 3개 받는 생성자
   public Car(String brand, String color, int price) {
      super();	// object 클래스의 기본 생성자 호출(생략해도 된다)
      this.brand = brand;
      this.color = color;
      this.price = price;
   }
   
//   시동 켜기 메소드
   void engineStart() {
      System.out.println("시동 켜기");
   }
//   시동 끄기 메소드
   void engineStop() {
      System.out.println("시동 끄기");
   }
}
//	Car 클래스를 상속받은 자식 클래스 SuperCar
class SuperCar extends Car{
//	추가 필드(모드 설정)
   String mode;
   
//   시동 켜기 메소드 오버라이드(기능 변경)
   @Override
   void engineStart() {
      System.out.println("음성으로 시동 켜기");
   }
//   SuperCar의 고유 메소드(오픈 루프)
   void openRoof() {
      System.out.println("뚜따");
   }
   
}

public class CastingTest01 {
   public static void main(String[] args) {
//	   업 캐스팅: 자식 클래스의 객체를 부모 객체에 저장
//	   부모 타입으로 선언하면 부모 클래스 멤버만 사용할 수 있다
      Car noOptionFerrari = new SuperCar();
      
//     다운 캐스팅: 업 캐스팅 한 부모의 객체를 자식 클래스 타입으로 변환
//     자식 클래스의 멤버를 사용하려면 다운캐스팅이 필요
      SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
      
//      부모 타입으로 만든 Car 객체
      Car matiz = new Car();
      
//      오류
//      부모 객체를 자식 클래스로 강제 변환하면 오류가 발생한다
//      SuperCar brokenFerrai = (SuperCar)new Car();

//      instanceof: 객체의 실제 타입을 확인(결과는 boolean으로 뜸)
      System.out.println(noOptionFerrari instanceof Car);	// true
      System.out.println(noOptionFerrari instanceof SuperCar);	// true
      System.out.println(fullOptionFerrari instanceof Car);	// true
      System.out.println(fullOptionFerrari instanceof SuperCar);	// true
      System.out.println(matiz instanceof SuperCar);	// false
      
   }
}














