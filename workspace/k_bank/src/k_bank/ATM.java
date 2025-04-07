package k_bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
   public static void main(String[] args) {
//      2차원 배열(3행 100열): 각 은행별로 100개의 계좌 저장 가능
      Bank[][] arrBank = new Bank[3][100];
      int[] arCount = new int[3];	// 각 은행의 현재 계좌 개수
      String message = "1. 신한은행\n2. 국민은행\n3. 카카오뱅크\n4. 나가기";
      String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행 선택 메뉴로 돌아가기";

      Scanner sc = new Scanner(System.in);	// 사용자의 입력 받기
      Random r = new Random();	// 랜덤 계좌 번호 생성기

//      사용자 정보 및 변수
      Bank user = null, temp = null;
      int bankNumber = 0, choice = 0;
      String account = "";	// 계좌 번호
      String name = null;	// 사용자 이름
      String password = null;	// 비밀번호
      String phone = null;	// 전화번호
      String[] phoneNumbers = null;
      int money = 0;	// 입출금 금액

//      은행 이름 배열
      String[] arName = { "신한은행", "국민은행", "카카오뱅크" };
//    출력 메시지들
      String accountMessage = "계좌번호: ";
      String nameMessage = "예금주: ";
      String passwordMessage = "비밀번호(4자리): ";
      String phoneMessage = "핸드폰번호(- 포함): ";
      String depositMessage = "입금액: ";
      String withdrawMessage = "출금액: ";
      String errorMessage = "다시 시도해주세요.";
      String loginFailMessage = "계좌번호 혹은 비밀번호를 다시 확인해주세요.";

//      무한 루프, true라는 값이 항상 참이기 때문에 사용자가 4번을 눌러 나갈 때까지 프로그램이 실행된다.
      while (true) {	// 은행 선택 메뉴
         System.out.println(message);
         bankNumber = sc.nextInt();	// 은행 선택 메뉴에서 사용자의 입력 받기

         if (bankNumber == 4) {	// 4. 나가기를 고르면 루프 및 프로그램 종료
            break;
         }

         while (true) {		// 은행 서비스 메뉴
            System.out.println(menu);
            choice = sc.nextInt();	// 서비스 선택 입력받기

            if (choice == 6) {	// 6번 선택 시 상위 메뉴로 이동
               break;
            }

            switch (choice) {
            // 1. 계좌 개설
            case 1:
               account = "";	// 계좌 번호 초기화
//                선택된 은행 객체 생성
               Bank[] arBank = { new Shinhan(), new Kookmin(), new Kakao() };
               user = arBank[bankNumber - 1];
//                랜덤 계좌 번호 생성 및 중복 검증
               while (true) {
//            	   계좌 번호의 뒤쪽 6자리를 랜덤하게 생성
                  for (int i = 0; i < 6; i++) {
//                	  랜덤 숫자를 생성해 문자열 형태로 계좌 번호를 만든다
                     account += r.nextInt(10);
                  }
//                  arrBank, arCount, account는 checkAccount 메소드에 사용되는 매개변수
//                  Bank.checkAccount는 중복된 계좌 번호가 있는지 확인하는 메소드
//                  주어진 account가 배열 arrBank에서 중복되는지 검사
                  if (Bank.checkAccount(arrBank, arCount, account) == null) {
                     break;
                  }
               }

               account = bankNumber + account;	// 은행 번호로 시작하는 계좌 번호 생성

               user.setAccount(account);
               user.setBankName(arName[bankNumber - 1]);

//               사용자 이름 입력
               System.out.println(nameMessage);	// user 객체
               name = sc.next(); // 사용자 이름을 입력받음
               user.setName(name);

//               핸드폰 번호 입력 및 검사
               while (true) {
//            	   핸드폰 번호를 입력하라는 메세지 출력
                  System.out.println(phoneMessage);
                  phone = sc.next(); // 사용자가 입력한 폰번호를 문자열로 가져온다
                  phoneNumbers = phone.split("-"); // 입력된 번호에서 -를 기준으로 분리하여 배열에 저장함

                  if (phoneNumbers.length == 3) {	// 전화 번호는 
                     if (phoneNumbers[0].length() == 3) {	// 지역 번호: 3자리
                        if (phoneNumbers[1].length() == 3 || phoneNumbers[1].length() == 4) {	// 중간 부분은 3자리 아님 4자리
                           if (phoneNumbers[2].length() == 4) {	// 마지막 부분은 4자리
                              phone = phone.replaceAll("-", "");	// "-" 제거
                              temp = Bank.checkPhone(arrBank, arCount, phone);
                              if (temp == null) {	// 중복이 없으면 진행(temp가 null이면 중복되지 않음)
                                 break;
                              }
                           }
                        }
                     }
                  }

                  System.out.println(errorMessage);	// 번호가 올바르지 않거나 중복되면 에러메시지 출력

               }
               user.setPhone(phone);	// 중복 검사를 통과하면 사용자 객체에 폰번호를 저장 

               while (true) {
//            	   비밀번호를 입력하라는 메세지 출력
                  System.out.println(passwordMessage);
                  password = sc.next();	// 사용자가 입력한 비밀번호를 문자열로 가져온다
                  if (password.length() == 4) {	//비밀번호는 4자리
                     break;
                  }

                  System.out.println(errorMessage);
               }

               user.setPassword(password);	// user 객체에 비밀번호를 저장

//               계좌의 정보 arrBank 배열에 저장
//               은행 번호가 1부터 시작하기 때문에 배열의 인덱스를 맞추기 위해 backNumber-1을 사용한다
               arrBank[bankNumber - 1][arCount[bankNumber - 1]] = user;
//               은행에 등록된 계좌 수를 arCount에서 증가시킴
               arCount[bankNumber - 1]++;

//               사용자가 가입한 은행의 이름을 출력
//               arName[bankNumber -1]은 은행 이름 배열에서 해당 은행의 이름을 가져옴
               System.out.println(arName[bankNumber - 1] + " 가입을 진심으로 환영합니다!");
//               사용자의 이름과 해당 사용자의 계좌번호 출력
               System.out.println(name + "님의 소중한 계좌번호: " + account);
               break;	// 계좌 등록을 완료하고 종료

//            2. 입금하기
            case 2:
               System.out.println(accountMessage);
               account = sc.next();	// 계좌 번호 입력

               System.out.println(passwordMessage);
               password = sc.next(); // 비밀번호 입력

               user = Bank.login(arrBank, arCount, account, password);	// 로그인 확인

//               사용자가 로그인에 성공했을 때 
               if (user != null) {
                  // 계좌를 개설한 은행인지 검사
//            	   user.getAccount().charAt(0)는 계좌번호의 첫 번째 문자(account의 첫 번째 자리)를 가져옴
//            	   여기서 charAt(0)는 문자열(String) 타입을 반환하므로, 이 문자에 48을 빼서 숫자로 변환한다.
                  if (bankNumber != user.getAccount().charAt(0) - 48) {	//48번 아스키코드: '0'
                     System.out.println(user.getBankName() + "에서만 입금 서비스를 이용하실 수 있습니다.");
                     break;
                  }

//                  아래와 같은 검사는 사실상 불가능하다.
//                  if (bankType instanceof Shinhan) {
//                     depositCheck = user instanceof Shinhan;
//                     
//                  } else if (bankType instanceof Kookmin) {
//                     depositCheck = user instanceof Kookmin;
//                     
//                  } else if (bankType instanceof Kakao) {
//                     depositCheck = user instanceof Kakao;
//                     
//                  }
//
//                  if(!depositCheck) {
//                     if(user instanceof Shinhan) {
//                        bankName = "신한은행";
//                        
//                     }else if(user instanceof Kookmin) {
//                        bankName = "국민은행";
//                        
//                     }else if(user instanceof Kakao) {
//                        bankName = "카카오뱅크";
//                        
//                     }
//                     
//                     System.out.println(bankName + "에서만 입금 서비스를 이용하실 수 있습니다.");
//                     break;
//                  }

//                  사용자가 입금을 요청할 때 뜨는 메시지
                  System.out.println(depositMessage);
                  money = sc.nextInt();	// 입금액 입력

//                  deposit 메소드 사용
                  user.deposit(money);	// 입금 처리
                  break;	// 정상적 처리 시 종료
               }
               System.out.println(errorMessage);	// 에러시 메시지 출력
               
               break;

//            3. 출금하기
            case 3:
               System.out.println(accountMessage);
               account = sc.next();	// 계좌 번호 입력

               System.out.println(passwordMessage);
               password = sc.next(); // 비밀번호 입력

//               입력받은 계좌와 비밀번호를 기준으로 arrBank에서 사용자를 찾아서 반환한다
//               로그인에 실패하면 user의 값은 null
               user = Bank.login(arrBank, arCount, account, password);

//               로그인에 성공하면
               if (user != null) {
//            	   출금 메시지를 출력
                  System.out.println(withdrawMessage);
//                  출금할 금액을 money = sc.nextInt();로 입력받습니다.
                  money = sc.nextInt();

//                  user 객체가 Kakao 클래스의 객체인지 검사
//                  true면 30%의 수수료를 포함한 금액으로 검증
//                  false면 수수료가 없으므로 money 그대로 검증
                  if (money * (user instanceof Kakao ? 1.3 : 1) <= user.getMoney()) {
                     user.withdraw(money);	// 출금 성공
                     break;
                  }
               }
               
               System.out.println(errorMessage);
               break;
               
//            잔액조회
            case 4:
               System.out.println(accountMessage);
               account = sc.next();	// 계좌 번호 입력

               System.out.println(passwordMessage);
               password = sc.next(); // 비밀번호 입력

//               사용자가 입력한 계좌랑 비밀번호를 통해 로그인 메소드를 수행
//               반환값은 user 객체, 로그인에 성공하면 null이 아니라 실제 user 객체를 반환
               user = Bank.login(arrBank, arCount, account, password);

//               로그인에 성공하면
               if (user != null) {
//            	   사용자의 계좌 잔액 정보를 가져온다
                  System.out.println(user.showBalance());
                  break;
               }

               System.out.println(errorMessage);	// 실패하면 에러메시지 출력
               break;

//            계좌번호 찾기
            case 5:
               account = "";
//               사용자에게 전화번호를 입력하라는 안내 메시지 출력
               System.out.println(phoneMessage);
               phone = sc.next();	// 사용자가 폰번호 입력
               phone = phone.replaceAll("-", "");	// 입력된 전화번호에서 하이픈(-)제거
               
//               계좌 비밀번호를 입력하라는 메시지 출력
               System.out.println(passwordMessage);
               password = sc.next();	// 사용자가 비밀번호 입력
               
//               Bank.checkPhone 메소드가 전화번호를 기준으로 arrBank 배열에서 사용자를 검색
               user = Bank.checkPhone(arrBank, arCount, phone);	// 전화번호로 계좌 검색
//				전화번호로 조회한 사용자가 존재해야함
//              user.getPassword().equals(password): 입력한 비밀번호가 사용자 계좌의 비밀번호와 일치하는지 검증 
               if (user != null && user.getPassword().equals(password)) {
//            	   계좌 번호의 첫 번째 문자를 아스키 코드에서 숫자로 변환
//            	   은행 번호를 추출하여 선택한 bankNumber와 비교
                   if (bankNumber != user.getAccount().charAt(0) - 48) {
//                	   선택한 은행(bankNumber)와 계좌의 실제 은행 정보가 다르면 해당 은행의 이름과 함께 메시지 출력
                      System.out.println(user.getBankName() + "에서 계좌를 찾으실 수 있습니다.");
                   } else {
//                	   일치한다면 현재 사용자의 이름과 계좌번호(user.getAccount())를 출력
                      System.out.println(name + "님의 소중한 계좌번호: " + user.getAccount());
                   }
                } else {	// 사용자 정보가 없거나 입력한 비밀번호가 일치하지 않으면 에러메시지 출력
                   System.out.println(errorMessage);
                }
                break;

             default:	// 기본값
                System.out.println(errorMessage); // 잘못된 입력 시
            }
         }
      }
   }
}












