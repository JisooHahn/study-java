package access1;

public class Car {
   private String brand;
   private String color;
   private int price;
   
   public Car() {;}

   public String getBrand() {
      return brand;
   }
   
//   Getter, Setter 단축키
//   Alt + Shift + s, r
   public void setBrand(String brand) {
      this.brand = brand;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }
}
