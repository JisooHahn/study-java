package classTest;

public class Market {
   Product[] arProduct;
   
   public Market() {;}

   public Market(Product[] arProduct) {
      this.arProduct = arProduct;
   }
   
   void sell(Customer customer, int choice) {
      customer.money -= arProduct[choice].price * (1 - customer.discount / 100.0);
      arProduct[choice].stock--;
   }
   
   
//   쉬움
//   String productName;
//   int productPrice;
//   int productStock;
//   
//   public Market() {;}
//
//   public Market(String productName, int productPrice, int productStock) {
//      this.productName = productName;
//      this.productPrice = productPrice;
//      this.productStock = productStock;
//   }
//
//   void sell(Customer customer) {
//      customer.money -= productPrice * (1 - customer.discount / 100.0);
//      productStock--;
//   }
   
}
