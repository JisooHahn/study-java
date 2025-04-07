package controlStatementTest;

import java.util.Scanner;

public class ForTask {
   public static void main(String[] args) {
//      브론즈
//      1 ~ 100까지 출력
//      for (int i = 0; i < 100; i++) {
//         System.out.println(i + 1);
//      }

//      100 ~ 1까지 출력
//      for (int i = 0; i < 100; i++) {
//         System.out.println(100 - i);
//      }

//      1 ~ 100까지 중 짝수만 출력
//      for (int i = 0; i < 50; i++) {
//         System.out.println((i + 1) * 2);
//      }

//      실버
//      1 ~ 10까지 합 출력
//      int total = 0;
//      for (int i = 0; i < 10; i++) {
////         total = total + i + 1;
//         total += i + 1;
////         System.out.println(total);
//      }
//      
////      System.out.println("==================");
//      System.out.println(total);

//      1 ~ n까지 합 출력(n은 입력받기)
//      Scanner scan = new Scanner(System.in);
//      String message = "1 ~ n까지의 합\nn: ";
//      int end = 0, total = 0;
//      
//      System.out.print(message);
//      end = scan.nextInt();
//      
//      for(int i=0; i<end; i++) {
//         total += i + 1;
//      }
//
//      System.out.println(total);

//      골드
//      A ~ F까지 출력
//      System.out.println((int)'D');
//      System.out.println((char)68);

//      for(int i = 0; i < 6; i++) {
//         System.out.println((char)(i + 65));
//      }

//      A ~ F까지 중 C 제외하고 출력(continue 사용하지 않기)
//      for (int i = 0; i < 5; i++) {
//         System.out.println((char)(i > 1 ? i + 66 : i + 65));
//      }

//      다이아

//      0 1 2 0 1 2 0 1 2 0 1 2 출력
//      for (int i = 0; i < 12; i++) {
//         System.out.print(i % 3 + " ");
//      }
//      System.out.println();

//      aBcDeF...Z 출력
      // 65 : 'A'
      // 97 : 'a'
//      for(int i = 0; i < 26; i++) {
//         System.out.print((char)(i % 2 == 0 ? i + 97 : i + 65));
//      }
//      System.out.println();

//      for문 1번만 써서 1단 ~ 9단까지
//      for (int i = 0; i < 81; i++) {
//         int first = i / 9 + 1, last = i % 9 + 1;
//         int result = first * last;
//
//         System.out.printf("%d * %d = %d\n", first, last, result);
//      }
   }
}
