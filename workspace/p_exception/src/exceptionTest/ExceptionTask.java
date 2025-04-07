package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
   public static void main(String[] args) {
//      5개의 정수만 입력받기
//      - 무한 입력 상태로 구현(5번 이상 입력 가능)
//      - q 입력 시 나가기
//      - 각 정수는 배열에 담기
//      - if문은 딱 한 번만 사용하기(q입력 시 나가기)
	   
	   // 입력받은 정수가 들어갈 크기 5의 배열 arData 생성
      int[] arData = new int[5];
      Scanner sc = new Scanner(System.in);	// 스캐너 객체 생성
      String temp = null;	// 사용자의 입력값을 임시로 저장할 공간
      int count = 0;	// 입력받은 정수의 개수를 세는 변수
      
      // break를 만날 때까지 반복
      while (true) {
    	  // ++count: 몇 번째 입력인지 출력
         System.out.print(++count + "번째 정수: ");	
         temp = sc.next();	// 사용자가 입력한 값을 문자열로 받아옴
         
         if(temp.equals("q")) {	// 입력값이 "q"라면
            break;	// 반복 종료
         }
         
//         예외 상황
         try {
//        	 사용자가 입력한 count와 실제 배열의 인덱스는 달라서 1을 빼준다.
//        	 사용자가 정수를 입력하면 temp가 정수로 변환되고, 배열 arData에 저장된다.
            arData[count - 1] = Integer.parseInt(temp); 
//       	 정수가 아닌 문자를 입력하면 변환 실패로 NumberFormatException이 발생
         } catch (NumberFormatException e) {
//            정수가 아닌 다른 것을 입력했을 때
//        	 사용자에게 잘못된 이용임을 알림
            System.out.println("정수만 입력해주세요.");
//            ++count로 이미 증가한 값을 줄여 순서를 보존(3번째 정수 입력 실패시 다시 3번째 정수 입력하게)
            count--;
//            배열에 입력할 정수의 개수를 초과했을 때에 발생
         } catch (ArrayIndexOutOfBoundsException e) {
//            6번째 정수를 입력했을 때
            System.out.println("5개 정수까지만 입력이 가능합니다.");
            break;	// 입력한 정수가 배열 크기 이상이므로 더 입력을 받지 않고 종료
//            앞서 쓴 예외를 제외한 처리되지 않은 예외가 발생하였을 때 
         } catch (Exception e) {
            e.printStackTrace();	//	예외 내역 출력
            System.out.println("다시 시도해주세요.");
         }
      }
//      arData의 모든 요소 출력하는 부분
      for (int i = 0; i < arData.length; i++) {
         System.out.print(arData[i] + " ");
      }
      
      System.out.println();


   }
}








