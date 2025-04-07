package classTest;

public class Product {
   String name;	// 상품 이름 
   int price;	// 상품 가격
   int stock;	// 재고
   
   //	기본 생성자(객체를 생성할 때 사용)
   public Product() {;}

   public Product(String name, int price, int stock) {
      this.name = name;
      this.price = price;
      this.stock = stock;
   }
}
