package abstractTest;

public class Refrigerator extends Electronics {

   @Override
   public void on() {
      System.out.println("버튼을 위로 올려서 전원 켜기");

   }

   @Override
   public void off() {
      System.out.println("버튼을 아래로 내려서 전원 끄기");

   }
}