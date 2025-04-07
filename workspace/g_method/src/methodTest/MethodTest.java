package methodTest;

import javax.swing.JOptionPane;

public class MethodTest {

//   f(x) = 2x + 1
   int f(int x) {
      return 2 * x + 1;
   }

//   이름, 나이 2개를 입력받아서 전체 정보 출력하는 메소드
   void printInfo(String name, int age) {
      System.out.println(name + ", " + age);
   }
   
//   정수 1개를 입력받고 제곱을 구해주는 메소드
   int square(int number) {
      return number * number;
   }
   
//   main 메소드: 실행 프로그램을 만들어주는 메소드
   
//   static
//   컴파일러가 가장 먼저 메모리에 할당해준다.
//   일반 메소드를 static 메소드에서 사용하기 위해서는 아래의 두 가지 방법이 존재한다.
//   1. 일반 메소드에 static을 작성하여 동시간대에 메모리로 올려준다.
//   2. 일반 메소드가 소속된 클래스를 Heap 메모리에 할당(new)하여 static이 감지할 수 있도록 한다.
   public static void main(String[] args) {
      MethodTest m = new MethodTest();
      int result = 0;
      
      m.f(10);
      m.printInfo("한동석", 20);
      
      result = m.square(2);
      
      System.out.println(result);
   }
}




