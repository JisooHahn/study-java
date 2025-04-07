package n_anonymous;

// 기본 인터페이스(수정불가)
public interface Form {
//	상품을 고르는 메소드
   public String[] getMenu();
//   물건을 판매하는 메소드(강남지점만 사용)
   public void sell(String order);
}
