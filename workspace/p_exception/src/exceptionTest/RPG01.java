package exceptionTest;

import java.util.Scanner;

public class RPG01{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = "닉네임: ";	// 닉네임을 입력하라는 메시지
		String nickName = null;	// 닉네임 초기값 설정
		
		System.out.println(message);
		nickName = sc.next();	// 스캐너로 닉네임 사용자에게 입력받기
		
		if(nickName.contains("바보")) {	// 입력받은 닉네임이 "바보"라는 글자를 포함한다면
//			반드시 예외를 처리할 때 사용하는 클래스
//			throw new Exception();
			
//			일부러 프로그램을 강제 종료시킬 때에 사용하는 클래스
//			throw new NicknameException("비속어 사용");
			try {
//				예외를 던지면 반드시 try catch 등으로 처리해야 함
				throw new NicknameException("비속어 사용");
			} catch (NicknameException e) {
				System.out.println("비속어는 사용하실 수 없습니다.");
			}
//			닉네임이 비속어를 포함하지 않을 시
		}else {
		System.out.println(nickName + "용사님 어서오세요.");
		}
	}
}
