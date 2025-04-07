package classTest;

// 자동차 클래스 선언
// 브랜드, 색상, 가격

// 시동 켜기, 시동 끄기
// 각 메소드는 브랜드명을 활용하여, 아래와 같이 출력한다.
// "브랜드 시동 켜짐", "브랜드 시동 꺼짐"
// 초기화된 브랜드명을 "브랜드"자리에 넣어서 출력한다.
class Car {
   static Long seq;
   Long id;
   String brand;
   String color;
   int price;
   
//   static 필드
//   생성자가 최초 호출되었을 때 딱 한 번만 실행되는 영역
   static {
       seq = 0L;
   }
   
//   초기화 필드
//   어떤 생성자가 호출되던지 먼저 실행되는 영역
   {
      id = ++seq;
   }
   
//   기본 생성자
//   반드시 기본 생성자를 선언한다.
   public Car() {;}
   
//   Alt + Shift + s, o
//   초기화할 필드 선택 후 엔터!
   public Car(String brand, String color, int price) {
      this.brand = brand;
      this.color = color;
      this.price = price;
   }

   void engineStart() {
      System.out.println(brand + " 시동 켜짐");
   }
   
   void engineStop() {
      System.out.println(brand + " 시동 꺼짐");
   }
   
   
}


public class ClassTask01 {
   public static void main(String[] args) {
      Car momCar = new Car("Benz", "Black", 35000);
      Car dadyCar = new Car("BMW", "Blue", 15000);
      Car myCar = new Car();
      
      System.out.println(momCar.id);
      System.out.println(dadyCar.id);
      System.out.println(myCar.id);
      
      momCar.engineStart();
      momCar.engineStop();
      
      dadyCar.engineStart();
      dadyCar.engineStop();
      
   }
}





