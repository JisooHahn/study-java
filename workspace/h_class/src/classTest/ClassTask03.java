package classTest;

//   화면
//   마트를 오픈해서 상품을 판매하고자 한다.
//   손님이 상품을 구매하면, 할인율에 맞게 가격이 조정된다.
//   손님들은 이름, 할인율, 잔액의 정보를 가지고 있다.

//   쉬움
//   마트는 1개의 상품만 판매한다.
//   상품명, 가격, 재고
//   판매하기

//   어려움
//   마트는 3개의 상품을 판매한다.
//   상품들
//   손님이 선택한 상품 판매하기

public class ClassTask03 {
   public static void main(String[] args) {
//	   arProduct라는 이름의 배열에 세 가지 상품 객체를 생성하여 저장.
//	   각 상품은 상품명, 가격, 재고 정보를 가지고 있다.
      Product[] arProduct = {
         new Product("새우깡", 500, 10),   
         new Product("감자깡", 900, 5),   
         new Product("맛동산", 500, 17),   
      };
      
//      arProduct 배열을 전달받아 Market 객체 emart를 생성
      Market emart = new Market(arProduct);
//      Customer 객체 ted 생성.
      Customer ted = new Customer("한동석", 50, 5000);
      
      emart.sell(ted, 1);
      
      System.out.println(ted.money);
      System.out.println(arProduct[1].stock);
      
//      Market emart = new Market("새우깡", 1500, 10);
//      Customer ted = new Customer("한동석", 50, 5000);
//      
//      emart.sell(ted);
//      
//      System.out.println(ted.money);
   }
}












