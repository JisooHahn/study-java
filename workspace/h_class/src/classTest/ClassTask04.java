package classTest;

// 회원
// 아이디, 이름, 이메일, 비밀번호

// 프로필 사진
// 경로, 파일 이름, 파일 크기(KB), 대표 이미지(status)

// 화면
// 회원 1명당 2개의 프로필 사진을 가지고 있다.
// 회원의 정보를 출력할 때, 대표 이미지만 출력한다.
public class ClassTask04 {
   public static void main(String[] args) {
      User ted = new User(1, "한동석", "tedhan1204@gmail.com", "1234", null);
      
      Profile img1 = new Profile("image/user", "img1", 300, true);
      Profile img2 = new Profile("image/user", "인생샷", 500, false);
      
      ted.arProfile = new Profile[2];
      ted.arProfile[0] = img1;
      ted.arProfile[1] = img2;
      
      ted.arProfile[0].check = false;
      ted.arProfile[1].check = true;
      
      System.out.println(ted.email + ", " + ted.name);
      for(int i=0; i<ted.arProfile.length; i++) {
         if(ted.arProfile[i].check) {
            System.out.println(ted.arProfile[i].fileName);
         }
      }
   }
}






