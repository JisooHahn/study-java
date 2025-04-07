package classTest;

// 유치원에 아이들이 다닌다.

// 유치원(Kindergarten)
// 이름, 주소, 정원

// 아이(Child)
// 이름, 나이

// 유치원에 다니는 아이들의 이름만 전체 출력
// 단, 3살 이상만 출력하라
public class ClassTask06 {
   public static void main(String[] args) {
      
      Kindergarten 병설유치원 = new Kindergarten();
      Child[] children = {
         new Child("영희", 3),
         new Child("철수", 5)
      };
      
      병설유치원.name = "병설";
      병설유치원.address = "경기도 고양시";
      병설유치원.count = 2;
      병설유치원.children = children;
      
      for(int i=0; i<병설유치원.children.length; i++) {
         if(병설유치원.children[i].age >= 3) {
            System.out.println(병설유치원.children[i].name);
         }
      }
      
//      Child 영희 = new Child();
//      영희.name = "영희";
//      영희.age = 3;
//      
//      병설유치원.name = "병설";
//      병설유치원.address = "경기도 고양시";
//      병설유치원.count = 2;
//      병설유치원.children = new Child[병설유치원.count];
//      병설유치원.children[0] = 영희;
//      
//      System.out.println(병설유치원.name);
//      System.out.println(병설유치원.address);
//      System.out.println(병설유치원.count);
//      System.out.println(병설유치원.children[0].name);
//      System.out.println(병설유치원.children[0].age);
   }
}
















