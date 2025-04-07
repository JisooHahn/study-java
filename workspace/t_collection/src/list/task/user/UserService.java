package list.task.user;

import java.util.Base64;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import list.task.DBConnecter;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserService {
   private static final int CERTIFICATED_NUMBER_LENGTH = 5;	// 인증번호의 길이
   public static Long id;	// 현재 로그인한 사용자 id를 저장하는 변수
   
//   이메일 중복검사
//   화면으로부터 사용자가 작성한 이메일을 받아온다.
   public User findByUserEmail(String email) {
//      빠른 for문(향상된 for문), forEach
//      DB에 있는 회원들을 순서대로 하나씩 user객체에 담아준다.
      for (User user : DBConnecter.users) {
//         DB에 있는 회원들의 이메일을 가져와서 사용자가 작성한 이메일과 같은지 검사
         if (user.getEmail().equals(email)) {
//            중복이 있을 때,
//            그 회원을 통채로 리턴한다.
//            Why? : 다른 메소드에서 이 리턴값을 활용하기 위해서
//            보통 서버에서는 boolean으로 리턴한다.
            id = user.getId();
            return user;
         }
      }
//      만약 중복된 이메일이 없으면, 이쪽으로 와서 null을 리턴한다.
      return null;
   }

//   회원가입
//   사용자가 입력한 회원의 전체 정보를 한 번에 받아온다.
   public void join(User user) {
//      전달받은 정보 중, 비밀번호를 암호화(인코딩)해서
      user.setPassword(encrpyt(user.getPassword()));
//      저장소에 저장한다.
      DBConnecter.users.add(user);
   }

//   로그인
//   사용자로부터 이메일과 비밀번호를 전달받는다.
   public User login(String email, String password) {
//      위에서 정의해놓은 이메일 검사 메소드를 통해 이메일 검사 진행.
      User user = findByUserEmail(email);

//      1. user가 null이 아닐 경우
//         정상 이메일
      if (user != null) {
//         그 이메일을 가진 회원의 비밀번호와 사용자가 전달한 비밀번호를 비교한다.
//         ★ 단, 회원가입시 비밀번호를 인코딩했기 때문에 비교할 때에도 인코딩하여
//         인코딩된 비밀번호끼리 비교해야한다!
         if (user.getPassword().equals(encrpyt(password))) {
//            로그인 성공
//            성공한 회원 정보 통채로 리턴
            id = user.getId();
            return user;
         }
      }
//      2. user가 null일 경우
//      잘못된 이메일
      return null;
   }
   
//   로그아웃
   public void logout() {
      id = null;
   }

//   암호화(인코딩)
//   원본 비밀번호를 전달받는다.
   public String encrpyt(String password) {
//      인코딩 방식 중, base64방식으로 비밀번호 문자열 값의 각 byte를 모두 인코딩시킨다.
      return new String(Base64.getEncoder().encode(password.getBytes()));
   }

//   개인 정보 수정(마이페이지)
   public void update(User newUser) {
//	   사용자 id가 일치하는 사용자를 찾아서 그 정보를 새로운 정보로 교체
      for (User user : DBConnecter.users) {
         if (user.getId() == newUser.getId()) {
            // 수정 완료
            user = newUser;
         }
      }
   }

//   비밀번호 변경
//   1. 로그인 후 비밀번호 변경
//   기존 비밀번호를 검사한 뒤 변경시킨다.
   public boolean checkPassword(String password) {
//	   DBConnecter.users에 저장된 사용자들을 순차적으로 검사
      for (User user : DBConnecter.users) {
//    	  로그인된 사용자의 id와 일치하는 사용자를 찾음
         if (user.getId() == id) {
//        	 기존 비밀번호랑 입력한 비밀번호가 같다면
            if(user.getPassword().equals(encrpyt(password))) {
//            	true 반환
               return true;
            }
         }
      }
      return false;	// 불일치하면 false 반환
   }

//   2. 로그인 전 비밀번호 변경
   public void changePassword(String newPassword) {
//	   로그인된 사용자 id로 사용자를 찾아서 비밀번호를 변경
      for (User user : DBConnecter.users) {
         if (user.getId() == id) {
            user.setPassword(encrpyt(newPassword));	// 새로운 비밀번호 암호화 후에 설정
         }
      }
   }

//   비밀번호 찾기
//   SMS API를 사용해서 임시 비밀번호 발송
   public void sendPassword(String phone) {
//	   	   임시 비밀번호 생성
	   	   String temp = makePassword();
	   	   
//	   	   SMS 발송을 위한 api 설정
	   	   String api_key = "";
	       String api_secret = "";
	       Message coolsms = new Message(api_key, api_secret);
	       

//	       SMS 발송에 필요한 파라미터 설정
	       // 4 params(to, from, type, text) are mandatory. must be filled
	       HashMap<String, String> params = new HashMap<String, String>();
	       params.put("to", phone);	// 수신자 전화번호
	       params.put("from", "01000000000");	// 발신자 전화번호
	       params.put("type", "SMS");	// SMS 유형
	       params.put("text", temp);	// 발송할 텍스트(여기선 인증번호)
	       params.put("app_version", "test app 1.2"); // application name and version

	       System.out.println(temp);
  
       try {
         JSONObject obj = (JSONObject) coolsms.send(params);
         
//          임시 비밀번호로 기존 비밀번호 변경
          for(User user: DBConnecter.users) {
             if(user.getPhone().equals(phone)) {
                user.setPassword(encrpyt(temp));
             }
          }
         
         System.out.println(obj.toString());
       } catch (CoolsmsException e) {
         System.out.println(e.getMessage());
         System.out.println(e.getCode());
       }
   }
//   랜덤한 5자리 임시 비밀번호 생성
   private String makePassword() {
      Random random = new Random();
      String passwordCharacter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-_=+0123456789";
      String temp = "";
      
      for (int i = 0; i < CERTIFICATED_NUMBER_LENGTH; i++) {
         temp += passwordCharacter.charAt(random.nextInt(passwordCharacter.length()));
      }
      
      return temp;
   }
   
//   인증번호 발송
   public String sendCertificatedNumber(String phone) {
      String api_key = "";
       String api_secret = "";
       Message coolsms = new Message(api_key, api_secret);
       String certificatedNumber = makeCertificatedNumber();

       // 4 params(to, from, type, text) are mandatory. must be filled
       HashMap<String, String> params = new HashMap<String, String>();
       params.put("to", phone);	// 수신자 전화번호
       params.put("from", "01000000000");	// 발신자 전화번호
       params.put("type", "SMS");	// SMS 유형
       params.put("text", certificatedNumber);	// 발송할 텍스트(인증번호)
       params.put("app_version", "test app 1.2"); // application name and version

//       인증번호 출력
       System.out.println(certificatedNumber);
       
//       실제 발송부분(주석처리)
//       try {
//         JSONObject obj = (JSONObject) coolsms.send(params);
//         System.out.println(obj.toString());
//       } catch (CoolsmsException e) {
//         System.out.println(e.getMessage());
//         System.out.println(e.getCode());
//       }
       
//       생성된 인증번호를 반환
       return certificatedNumber;
   }
   
//   인증번호 생성
   private String makeCertificatedNumber() {
//	   random 생성기 초기화
      Random random = new Random();
      String certificatedNumber = "";
      
//      인증번호 길이(5)만큼 숫자 랜덤 생성
      for (int i = 0; i < CERTIFICATED_NUMBER_LENGTH; i++) {
//    	  0~9까지의 랜덤 숫자를 한 자리씩 생성하여 인증번호 문자열에 추가
         certificatedNumber += random.nextInt(10);
      }
//      최종 생성된 인증번호를 반환
      return certificatedNumber;
   }
// 회원 번호로 회원 조회
 public User findById() {
//	 현재 로그인된 사용자가 없으면 null 반환
    if (id == null) {
       return null;
    }

//    DB에 저장된 사용자 리스트를 순차적으로 확인(빠른 for문, forEach)
    for (User user : DBConnecter.users) {
//    	현재 로그인된 사용자의 id와 동일한 id를 가진 사용자를 찾음
       if (user.getId() == id) {
//    	   해당 사용자를 찾았다면 그 사용자 객체를 반환
          return user;
       }
    }
//	해당 id를 가진 사용자가 없으면 null 반환
    return null;
 }

}











