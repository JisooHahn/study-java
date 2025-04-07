package n_anonymous;

//	강남지점에서 Form 인터페이스에 있는 sell 옵션을 안 쓰기 위해 FormAdapter 사용
public abstract class FormAdapter implements Form {

//	인터페이스의 메소드를 오버라이드로 재정의
   @Override
//   인터페이스에 정의된 모든 메소드를 구현해야 하기 때문에
//   추상 클래스에서 빈 내용으로 구현한 것이다.
   public void sell(String order) {;}

}
