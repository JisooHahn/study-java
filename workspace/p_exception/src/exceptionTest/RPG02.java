package exceptionTest;

import java.util.Scanner;

public class RPG02 {
//   캐릭터 이름을 입력받고,
//   "멍청이", "바보", "똥개"가 포함된 이름은
//   예외를 발생시켜 사용자에게 경고 메세지를 출력해준다.
//   ※ 강제 종료하지 않는다.
   
//	매개변수로 받은 닉네임에 비속어가 포함되어 있을 경우 던져질 예외
//	예외를 던질 때는 예외 클래스를 사용하기 때문에 throw 뒤에 예외 클래스의 객체를 생성하고 던짐
   void checkNickname(String nickname) throws NicknameException{
//	   비속어 목록 배열에서 비속어 설정
      String[] arName = {"멍청이", "바보", "똥개"};
      
      for (int i = 0; i < arName.length; i++) {
//    	  닉네임 문자열에 비속어 목록 arName이 포함되어있는지 확인하기 위해 contains 메소드 사용
         if(nickname.contains(arName[i])) {
//        	 위쪽에 throws를 써서 에러가 발생하지 않는다
//        	 비속어가 발견된다면 NicknameException 예외를 던진다
            throw new NicknameException();
         }
      }
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      RPG02 rpg = new RPG02();	// RPG02 클래스의 새로운 객체 생성
      String message = "캐릭터명: ";
      String nickname = null;	// 사용자에게 입력되는 닉네임
      
      System.out.print(message);
      nickname = sc.next();
      
      try {
         rpg.checkNickname(nickname);	// 닉네임을 검사받는 메소드 호출
         System.out.println("캐릭터명: " + nickname);	// 정상적인 닉네임 호출
      } catch (NicknameException e) {	// 비정상적인 닉네임
         System.out.println("사용할 수 없는 닉네임입니다.");	
      }
   }
}












