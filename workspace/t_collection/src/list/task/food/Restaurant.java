package list.task.food;

import java.util.ArrayList;
import java.util.List;

import list.task.DBConnecter;

public class Restaurant {
//   음식 이름 검사
//	equals()를 오버라이딩해서 비교하면 새로 생성된 객체라도 기존 객체와 
//	같은 데이터를 가지면 동일한 객체로 판단된다. 결국 오버라이딩!
   public Food checkName(Food anotherFood) {
//      Food 타입의 메소드 이며 매개변수로 anotherFood  
      
      for(Food food: DBConnecter.foods) {
//     컬렉션 의 각 요소를 순차적으로 가져와 food 변수에 저장하면서 반복문을 실행합니다.
         if(food.equals(anotherFood)) {
//      반복하며 저장된 값들중 anotherFood 와 비교하여 같으면 food 를 리턴함,
//            
            return food;
         }
      }
//      같지않다면 null 을 반환
      return null;
   }
   
   public Food checkName(String name) {
      
      for(Food food: DBConnecter.foods) {
         if(food.getName().equals(name)) {
            return food;
         }
      }
      
      return null;
   }
   
//   새로운 음식 추가
   public void save(Food food) {
      DBConnecter.foods.add(food);	// 음식 리스트에 추가
   }
   
//   음식 이름으로 음식 종류 조회
   public String findKind(String name) {
//      for(Food food: DBConnecter.foods) {
//         if(food.getName().equals(name)) {
//            return food.getType();
//         }
//      }
      Food food = checkName(name);
//    checkname 메소드를 사용해서 name 매개변수를 검사하여 food에 저장, 
      return food == null ? null : food.getType();
//    checkName 의 리턴값에 따라 null 을 반환하거나, food.getType() 반환함
   }
   
//   사용자가 원하는 종류의 음식 전체 조회
   public List<Food> findAllByType(String type){
//      type 이라는 문자열을 매개변수로 받아 같은 값을 가진 type의 Food 객체를 찾음.
      ArrayList<Food> results = new ArrayList<Food>();
//     Food 객체들을 저장할수 있는 ArrayList 타입의 results 변수를 생성하고., 빈 리스트로 초기화하는 코드이다.
      for(Food food: DBConnecter.foods) {
//     foods에 저장된 각 요소들을 순차적으로 food 에 저장함,
         if(food.getType().equals(type)) {
//            food 타입이 매개변수 type과 값이 같으면 results의 ArrayList 에 food 를 추가함.
            results.add(food);
         }
      }
//      같지않으면 results에 저장함.
      return results;
   }
   
   
//   음식 종류 수정 후 가격 10% 상승
   public void update(Food newFood) {
//      
      Food food = checkName(newFood);
//      newFood를 조회, 리턴값을 food 에 저장,
//     checkName 리턴값이 null이 아닐때
      if(food != null) {
         
//      newFood 타입을 food 타입으로 사용,
         food.setType(newFood.getType());
//      newFood 객체의 가격을 가져와서 1.1 만큼 곱함 
//       정수형으로 바꿔서 소수점 쳐낸값을 food객체의 가격으로 설정
         food.setPrice((int)(newFood.getPrice() * 1.1));
      }
   }
   
//   사용자가 원하는 종류의 음식 개수 조회
   public int getCount(String type) {
      int count = 0;
      for(Food food: DBConnecter.foods) {
         if(food.getType().equals(type)) {
            count ++;
         }
      }
      
      return count;
   }
}


















