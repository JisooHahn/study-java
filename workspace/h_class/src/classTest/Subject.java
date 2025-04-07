package classTest;

public class Subject {
//   과목명
   String name;
//   과목 점수
   int score;
//  생성자로 과목의 이름과 점수를 받는다!
//  객체를 생성하려면 초기값이 필요하기 때문에 이 역할을 생성자가 한다
   public Subject() {;}

//   매개변수가 있는 생성자, 과목 이름과 점수를 초기화할 수 있음
   public Subject(String name, int score) {
//	   name값을 클래스의 인스턴트 변수에 할당
//	   다른 클래스의 객체의 인스턴트 변수로 선언하고 사용하는것
      this.name = name;
      this.score = score;
   }
}
