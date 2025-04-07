package list.task.user;

import list.task.DBConnecter;

public class Page {
   public static void main(String[] args) {
	   
//	   UserService 객체 생성
      UserService userService = new UserService();
      
//     User 객체 생성 (회원 정보를 담을 객체) 
      User user = new User();
      
//      인증번호를 저장할 변수 초기화
      String certificatedNumber = null;
      
//      전화번호를 저장할 변수 초기화
      String phone = null;
      
//      회원 이메일 설정
      user.setEmail("hds1234@gmail.com");

//      회원가입
//      DB에 이메일이 존재하는지 확인(중복 체크)
      if(userService.findByUserEmail(user.getEmail()) == null) {
//    	  중복이 없으면 비밀번호와 전화번호 설정 후 회원가입 진행
         user.setPassword("1234");
         user.setPhone("01012341234");
         
//         UserService의 join() 메소드 호출하여 회원가입 수행
         userService.join(user);
      }
      
//      로그인
//      새로운 User 객체를 생성(입력값을 담기 위한 객체)
      user = new User();
      
//      로그인 할 이메일과 비밀번호를 설정
      user.setEmail("hds1234@gmail.com");
      user.setPassword("1234");
      
//      Login() 메소드를 호출하여 로그인 시도
      user = userService.login(user.getEmail(), user.getPassword());
      
//      로그인 성공 여부 확인
      if(user != null) {
         System.out.println("로그인 성공!");
         System.out.println(user);	// 로그인한 사용자 정보 출력
      }else {
         System.out.println("이메일 또는 비밀번호를 다시 확인해주세요.");
      }
      
//      회원 정보 수정
//      현재 로그인한 사용자 정보 가져오기(중복검사 메소드)
      user = userService.findById();
//      사용자의 이메일 변경(set)
      user.setEmail("test@gmail.com");
//      변경된 정보를 UserService의 update() 메소드를 통해 반영
      userService.update(user);
      
//      모든 사용자 목록을 출력(변경된 정보 확인)
      System.out.println(DBConnecter.users);
      
//      임시 비밀번호
//      전화번호 설정
      phone = "01012341234";
      
//      인증번호 요청(휴대폰으로 전송)
      certificatedNumber = userService.sendCertificatedNumber(phone);
      
//      인증번호가 "12345"로 입력되었을 경우
      if(certificatedNumber.equals("12345")) {
//    	  임시 비밀번호 발송
         userService.sendPassword(phone);
      }
      
//      변경된 비밀번호 확인을 위해 사용자 목록 출력
      System.out.println(DBConnecter.users);
      
//      로그인 후 비밀번호 변경
      user = userService.findById();
      
//      로그인한 사용자가 존재하면 비밀번호 변경
      if(user != null) {
         userService.changePassword("9999");
      }
      
//      변경된 사용자 정보 출력(비밀번호 변경 확인)
      System.out.println(DBConnecter.users);
      
//      현재 로그인한 사용자의 ID 출력 (로그아웃 전)
      System.out.println(UserService.id);
      
//      로그아웃 처리
      userService.logout();
      
//      로그아웃 후 ID 확인 (null이어야 정상)
      System.out.println(UserService.id);
   }
}

















