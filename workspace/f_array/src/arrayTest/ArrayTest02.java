package arrayTest;

import java.util.Scanner;

public class ArrayTest02 {
   public static void main(String[] args) {
//      나는 건물주!
      int[] arPay = new int[3];
      Scanner scan = new Scanner(System.in);
      
      for(int i=0; i<arPay.length; i++) {
         System.out.println(i + 1 + "번 집 월세: ");
         arPay[i] = scan.nextInt();
      }
      
      for(int i=0; i<arPay.length; i++) {
         System.out.println(i + 1 + "번 방 월세: " + arPay[i] + "만원");
      }
      
   }
}










