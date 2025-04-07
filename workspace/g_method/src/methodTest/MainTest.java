package methodTest;

public class MainTest {
	// cmd창에서 .java파일 경로로 이동하고(cd 명령어)
	// javac 명령어로 해당 파일 컴파일 진행
	// 경로에서 뒤로 이동한 뒤 java package명.class파일명을 작성한다.
	
   // main 메소드의 매개변수는 외부에서(CLI) 전달받은 네트워크 정보나
   // 명령어의 옵션값 등을 받기 위해 설계되었다.
   // 따라서 앞으로 백엔드 개발에 있어서 사용할 일이 거의 없다.
   public static void main(String[] args) {
      if(args.length == 0) {
         System.out.println("None");
      }else {
         for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
         }      
      }
   }
}
