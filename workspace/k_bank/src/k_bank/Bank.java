package k_bank;

public class Bank {
//   변수
//   예금주
   private String name;

//   계좌번호
   private String account;

//   핸드폰번호
   private String phone;

//   비밀번호
   private String password;

//   잔액(통장)
   private int money;

//   은행명
   private String bankName;

//   기본 생성자(매개변수 없음)
   public Bank() {;}
   
//	매개변수가 있는 생성자
   public Bank(String name, String account, String phone, String password, int money, String bankName) {
      super();
      this.name = name;	// 예금주
      this.account = account;	// 계좌번호
      this.phone = phone;	// 폰번호
      this.password = password;	// 비밀번호
      this.money = money;	// 잔액
      this.bankName = bankName;	// 은행명
   }
   
//  getter, setter를 쓰는 이유? 캡슐화를 위하여
//  객체의 내부 데이터를 직접 접근하는 것을 제한하고(private), 메소드를 통해 수정하게 함
//  getter: 객체의 내부 데이터를 읽어올 수 있도록 하는 메소드
//  setter: 객체의 내부 데이터를 외부에서 변경할 수 있도록 하는 메소드
   
//	예금주의 이름을 반환하는 getter
   public String getName() {
      return name;
   }
//	예금주의 이름을 설정하는 setter
   public void setName(String name) {
      this.name = name;
   }

   public String getAccount() {
      return account;
   }

   public void setAccount(String account) {
      this.account = account;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public int getMoney() {
      return money;
   }

   public void setMoney(int money) {
      this.money = money;
   }

   public String getBankName() {
      return bankName;
   }

   public void setBankName(String bankName) {
      this.bankName = bankName;
   }

   // 계좌번호 중복검사
//   이미 존재하는 계좌번호가 있는지 확인
//   arrBank는 2차원 배열
   public final static Bank checkAccount(Bank[][] arrBank, int[] arCount, String account) {
//	   2차원 배열을 순회하며 계좌번호를 찾음
//	   행 부분 반복
      for (int i = 0; i < arrBank.length; i++) {
//    	  우리는 여기서 고정된 계좌 수 100개가 아니라 실제 사용자의 수만큼 반복문을 돌릴 것이기 때문에
//    	  열 수가 고정되어 있지 않고, 실제로 해당 행에 존재하는 계좌 수를 arCount[]로 동적으로 반영한다.
//    	  100개로 하면 배열의 초기값을 null이기 때문에, 에러가 발생할 것이다.
         for (int j = 0; j < arCount[i]; j++) {	// 각 행의 계좌 수만큼 반복
//        	 arrBank[i][j].account는 i번째 은행의 j번째 계좌의 계좌 번호이다.
//        	 account는 매개변수로 전달된 계좌 번호로, 현재 찾고자 하는 계좌 번호이다.
//        	 .equals(account)는 문자열 비교를 위한 메소드- account와 arrBank[i][j].account가 같은지 확인한다.
            if (arrBank[i][j].account.equals(account)) {
               return arrBank[i][j]; // 중복된 계좌를 찾으면 해당 계좌를 반환
            }
         }
      }

      return null;	// 계좌를 찾지 못하면 null값 반환
   }

//   핸드폰번호 중복검사
   public final static Bank checkPhone(Bank[][] arrBank, int[] arCount, String phone) {
//	   2차원 배열, 행(은행 3개) 부분 반복
      for (int i = 0; i < arrBank.length; i++) {
//    	  열(현재 등록된 계좌 수)만큼 반복
         for (int j = 0; j < arCount[i]; j++) {
//        	 arrBank[i][j].phone이 phone과 같은지(중복되는지) 조건을 걸었다
            if (arrBank[i][j].phone.equals(phone)) {
               return arrBank[i][j]; // 중복된 번호를 찾으면 해당 계좌 반환
            }
         }
      }

      return null;	// 계좌를 찾지 못하면 null 반환
   }

//   로그인
//   사용자가 계좌번호와 비밀번호를 입력하여 시스템에 로그인하려고 할 때 정보가 유효한지 검사한다.
//   arrBank에서 사용자의 계좌를 찾고, 그 계좌의 비밀번호와 사용자가 입력한 비밀번호가 맞는지 검사한다.
   public static final Bank login(Bank[][] arrBank, int[] arCount, String account, String password) {
//	   계좌 번호로 계좌를 찾는 메소드 호출(checkAccount) 사용하는 매게변수 소괄호 안에 써야댐
      Bank user = checkAccount(arrBank, arCount, account);
//      윗쪽 메소드에서 중복된 계좌가 있다면 계좌의 값, 없으면 null을 반환하기 때문에 계좌번호 중복검사를 통과했냐 묻는 조건문이다
//      Bank의 개체 user의 값이 null이 아니라면(중복되는 계좌번호가 있다면)
      if (user != null) {
//    	  계좌번호 다음으로 user의 비밀번호도 중복되는지 묻는다. 비밀번호도 동일하면
         if (user.password.equals(password)) {
        	 // user의 값을 반환
            return user;
         }
      }
      // 동일하지 않으면(로그인 실패) null 반환
      return null;
   }

//   입금
//   정수 money를 매개변수로 사용하여 입금한 금액만큼 보유 금액에 더하는 메소드
//	 this.money는 계좌의 현재 잔액을 나타내는 필드
   public void deposit(int money) {
      this.money += money;
   }

//   출금
//   정수 money를 매개변수로 사용하여 출금한 금액만큼 보유 금액에 빼는 메소드
   public void withdraw(int money) {
      this.money -= money;
   }

//   잔액 조회
//	현재 잔액을 리턴하는 메소드
   public int showBalance() {
      return this.money;
   }
}
