package n_anonymous;

//	강남, 잠실 두개의 Nike 지점을 만들어서 다른 방식으로 register 설ㅈ정
public class Building {
   public static void main(String[] args) {
//	   Nike 클래스의 각 지점 만들기
      Nike gangnam = new Nike();
      Nike jamsil = new Nike();
//      잠실 지점: FormAdapter를 사용(sell을 구현하지 않음)-익명 클래스
      jamsil.register(new FormAdapter() {
         
         @Override
         public String[] getMenu() {
//        	 메뉴 항목을 리턴
            return new String[] { "운동화", "셔츠", "축구공" };
         }
      });
//      강남 지점: 익명 클래스를 사용하여 Form 인터페이스를 구현
      gangnam.register(new Form() {

         @Override
         public void sell(String order) {
//        	 getMenu 메소드
            String[] menu = getMenu();	// 메뉴를 가져옴
            for (int i = 0; i < menu.length; i++) {
//            	주문 품목이 메뉴에 있으면
               if (menu[i].equals(order)) {
//            	   판매 후 메세지 출력
                  System.out.println(menu[i] + " 판매 완료");
               }
            }

         }

         @Override
         public String[] getMenu() {
            return new String[] { "운동화", "셔츠", "축구공" };
         }
      });
   }
}