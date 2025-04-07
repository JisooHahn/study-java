package list.test;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
   public static void main(String[] args) {
      // <?>: 제네릭(이름이 없는)
      // 객체화할 때 타입을 지정하는 기법
      // 자료구조를 설계할 때 데이터의 타입을 지정할 수 없기 때문에 임시로 타입을 선언한다.
      // 따로 다운 캐스팅할 필요가 없으며, 지정할 타입에 제한을 줄 수 있기 때문에 Object와 목적이 다르다.
      
      ArrayList<Integer> datas = new ArrayList<Integer>();
      
      System.out.println(datas.size());
      
      datas.add(40);
      datas.add(50);
      datas.add(90);
      datas.add(70);
      datas.add(10);
      datas.add(80);
      datas.add(30);
      datas.add(20);
      
      System.out.println(datas);
      System.out.println(datas.size());
      
      Collections.sort(datas);
      System.out.println(datas);
      
      Collections.reverse(datas);
      System.out.println(datas);
      
      Collections.shuffle(datas);
      System.out.println(datas);
      
//      추가(삽입), 60은 항상 30뒤에 삽입한다.
      if(datas.contains(30)) {
         datas.add(datas.indexOf(30) + 1, 60);
         System.out.println(datas);
      }else{
         System.out.println("30은 없습니다.");
      }
      
//      수정, 10을 1로 수정한다.
      if(datas.contains(10)) {
         System.out.print("수정 전: ");
         System.out.println(datas.set(datas.indexOf(10), 1));
         
         System.out.println("수정 후: ");
         System.out.println(datas);
      }else {
         System.out.println("10이 없습니다.");
      }
      
      
//      삭제(값으로 삭제), 20을 삭제한다.
      if(datas.remove(Integer.valueOf(20))) {
         System.out.println("삭제 성공");
         System.out.println(datas);
      }else {
         System.out.println("삭제 실패");
      }
      
//      삭제(인덱스로 삭제), 50을 삭제한다.
      int i = datas.indexOf(50);
      if(i != -1) {
         System.out.println(datas.remove(i) + " 삭제 성공");
         System.out.println(datas);
      }else {
         System.out.println("삭제 실패");
      }
      
//      조회
//      System.out.println(datas.get(3));
      for(int data: datas) {
         System.out.println(data);
      }
   }
}


















