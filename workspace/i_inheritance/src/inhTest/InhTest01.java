package inhTest;

//	부모 클래스 A 정의
class A {
   String name; // name 필드 정의
   
   // A 클래스의 생성자
   public A() {
	   // 생성자는 객체가 생성될 때 메세지를 출력한다.
      System.out.println("부모 생성자 호출");
   }
}

//	자식 클래스 B 정의, A 클래스를 상속받음
//	extends는 클래스를 확장, A 클래스를 자식이 물려받는 키워드
class B extends A{
   public B() {
	   // super를 사용하여 부모 클래스의 생성자를 호출한다
      super();
      System.out.println("자식 생성자 호출");
   }
}

//	메인 클래스
public class InhTest01 {
   public static void main(String[] args) {
	   // B 클래스의 객체 생성
      B b = new B();
      
      // B 클래스의 A한테서 상속받은 필드 name 사용
      b.name = "B 클래스";
      System.out.println(b.name); // name 필드 값 출력
   }
}

