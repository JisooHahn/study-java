package n_anonymous;

public class Nike {
//	register 메소드 - Form 인터페이스를 구현한 객체를 받음
   public void register(Form form) {
//	   form에서 menu를 가져와 출력
      String[] menu = form.getMenu();
      
      for (int i = 0; i < menu.length; i++) {
         System.out.println(menu[i]);
      }
      
//      FormAdapter를 쓴다면(잠실 지점이라면)
//      instanceof로 검사
      if(form instanceof FormAdapter) {
         System.out.println("무료 나눔 매장");
         return;	// 추가 작업 없이 메소드 종료
      }
//      FormAdapter가 아니라면 판매 메소드 호출
      form.sell("운동화");	// 운동화 주문 처리
   }

}
