package classTest;

//   화면
//   학생의 점수를 입력받은 뒤 총점과 평균을 출력한다.
//   학생의 점수는 생성자로 초기화한다.
//   모든 학생은 공통적으로 총점과 평균을 가지고 있다.
public class ClassTask02 {
   public static void main(String[] args) {
//	   Student에 있는 Subject 
      Subject[] arSubject = {
            new Subject("국어", 30),
            new Subject("영어", 100),
            new Subject("수학", 70)
      };
//      Student 객체 생성
      Student ted = new Student(1, arSubject);
//      총점과 평균 출력
      System.out.println(ted.total);
      System.out.println(ted.average);
   }
}