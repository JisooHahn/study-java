package classTest;

import java.util.Random;

public class RandomTest {
   public static void main(String[] args) {
      Random random = new Random();
//      System.out.println(random.nextInt(2));
      
//      확률
//      1. 단위 정하기
//      2. 확률 정하기
      
//      10단위, 30%
      int rating = 30;
      int[] arData = new int[10];
      for (int i = 0; i < rating / 10; i++) {
         arData[i] = 1;
      }
      
      for (int i = 0; i < arData.length; i++) {
         System.out.println(arData[i]);
      }
      
      if(arData[random.nextInt(arData.length)] == 1) {
//         30% 확률로 들어옴
         System.out.println("주문서 발림");
      }else {
//         70% 확률로 들어옴
      }
   }
}













