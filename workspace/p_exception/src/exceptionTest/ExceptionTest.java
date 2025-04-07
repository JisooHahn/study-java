package exceptionTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
   public static void main(String[] args) {
//      int[] arData = new int[5];
//
//      try {
//         System.out.println(arData[4]);
//         System.out.println("오류 없음");
//         
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
      
//      사용자에게 정수를 입력받고 10을 더해서 출력하기
//      만약, 정수가 아닌 다른 값을 입력했다면 예외를 처리해준다.
	   
      Scanner sc = new Scanner(System.in); // 정수를 입력받아야 하니 스캐너 객체 생성
      String message = "정수 :";	// 사용자를 위해 뜨는 메시지
      int number = 0;
      
      System.out.print(message);
      
      try {	// 예외가 발생할 수 있는 코드
         number = sc.nextInt(); // 사용자가 입력한 값을 정수 number에 저장
         System.out.println(number + 10);
         
      } catch (InputMismatchException e) {	// 예외가 발생했을 시에
//         e.printStackTrace();	// 예외내역을 출력해주는 메소드
         System.out.println("정수만 입력하세요.");	// 예외메시지 출력
         // 모든 종류의 예외가 포함되어있는 클래스
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}


















