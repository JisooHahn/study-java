package classTest;

public class Student {
//   학생 번호
   int id;
   
//   과목들
//   여기서 arSubject는 Subject 클래스의 객체들을 저장하는 배열
//   Subject[]는 Subject 객체들의 배열을 의미한다
   Subject[] arSubject;
//   총점
   int total;
//   평균
   double average;

   public Student() {
      ;
   }

// 생성자: 학생의 id와 과목 배열을 입력받음
   public Student(int id, Subject[] arSubject) {
//	  여기서 id는 매개변수로 사용된다. 이건 생성자 내부에서 임시적으로 생성된 값이다.
//	  this.id는 현재 객체(인스턴스)의 속성을 나타낸다. this를 사용하여 **객체의 필드(변수)**에 접근하는 것이다
//	  this를 생략하게 되면 id=id처럼 자기 자신에게 값을 대입하기 때문에 아무 작업도 안 하게 된다
//	  초기화가 안 되면 우리가 원하는 특정한 유효값으로 설정되지 않는다.
      this.id = id;
      this.arSubject = arSubject;

//    총점과 평균을 구하는 메소드
      
//    arSubject의 값이 입력되지 않으면 null이기 때문에, 입력 여부를 조건문으로 판단
      if (arSubject != null) {
//    	 arSubject의 길이만큼 반복문을 실행하여 각 과목의 점수를 하나씩 처리
         for (int i = 0; i < arSubject.length; i++) {
//        	arSubject[i].score는 arSubject 배열의 i번째 과목의 점수를 가져온다
//        	total에 해당 점수를 더하여 누적.
//        	this.total은 해당 객체의 총점 필드를 나타냄
            this.total += arSubject[i].score;
         }
//       총점(total)을 과목의 수(arSubject.length)f로 나누어 평균을 구함
//       평균을 소숫점 단위까지 계산하기 위해 int인 total을 double로 변환한다 
         this.average = (double)this.total / arSubject.length;
//       this.average를 소숫점 두 자리까지 포맷한다.
//       이렇게 포맷한 문자열을 다시 double로 변환한다
         this.average = Double.parseDouble(String.format("%.2f", this.average));
      }
   }
}









