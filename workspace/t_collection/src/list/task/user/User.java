package list.task.user;

import java.util.Objects;

//	회원 정보를 저장하는 클래스 
public class User {
//   회원번호, 이름, 이메일, 비밀번호, 핸드폰 번호
   private static Long seq;
   private Long id;
   private String email;
   private String password;
   private String phone;
   
//   모든 User 객체가 공유하는 변수
   static {
//	   seq는 회원 id 자동 증가를 위한 변수
      seq = 0L;
   }
   
   {
//	   새로운 User 객체가 생길 때마다 id가 자동 증가하도록 설정
//	   생성할 때마다 seq 값이 1씩 증가하고, 그 값을 id에 저장한다.
      id = ++seq;
   }
   
//   기본 생성자
   public User() {;}

//   매개변수가 있는 생성자(오버라이딩이 아니라 오버로딩)
//   User 객체 초기화
   public User(String email, String password, String phone) {
      super();
      this.email = email;
      this.password = password;
      this.phone = phone;
   }

//   getter & setter(반환, 변경)
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   @Override
   public String toString() {
//	   User 객체를 출력할 때 객체의 정보를 보기 쉽게 문자열로 변환
      return "User [id=" + id + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
   }

   @Override
//   두 User 객체가 동일한지 비교할 때 id가 동일한지 확인
//   equals를 오버라이딩해서 객체의 특정 필드 값을 기준으로 비교할 수 있다!
   public boolean equals(Object obj) {
      if (this == obj)	// 1. 동일한 객체인지 비교
         return true;
      if (obj == null)	// 2. 비교 대상이 null이면 false 반환
         return false;
      if (getClass() != obj.getClass())	// 3. 클래스 타입이 다르면 false 반환
         return false;
      User other = (User) obj;	// 4. obj를 User 타입으로 캐스팅(다운캐스팅)
      return Objects.equals(id, other.id);	// 5. id 필드값이 동일하면 true 반환
   }
}














