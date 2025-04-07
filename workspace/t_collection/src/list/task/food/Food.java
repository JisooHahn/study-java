package list.task.food;

import java.util.Arrays;
import java.util.Objects;

public class Food {

   private String name;
   private int price;
   private String type;

   
//   생성자
   public Food() {
      ;
   }

   public Food(String name, int price, String type) {
      super();
      this.name = name;
      this.price = price;
      this.type = type;
   }
   
//   getter, setter

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "Food [name=" + name + ", price=" + price + ", sort=" + type + "]";
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)	// 동일한 객체인지 확인(주소값)
         return true;
      if (obj == null)	// 비교 대상이 null인지 확인
         return false;
      if (getClass() != obj.getClass())	// 같은 클래스인지 확인
         return false;
//      equals()메소드는 Object 클래스에서 제공하는 거라 모든 클래스가 오버라이딩 할 수 있다.
//      하지만 Object obj는 원래 Food 타입이 아니기 때문에, Food 클래스의 필드에 직접 접근하려면 다운캐스팅 필요
      Food other = (Food) obj;	// Food 타입으로 캐스팅(다운캐스팅)
      
      return Objects.equals(name, other.name) && price == other.price && Objects.equals(type, other.type);
   }

}
