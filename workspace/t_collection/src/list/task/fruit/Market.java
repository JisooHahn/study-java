package list.task.fruit;

import java.util.List;

import list.task.DBConnecter;

public class Market {
//   과일 이름 검사
   public Fruit checkName(String name) {
//	   빠른 for문: DB에서 fruits List를 가져와 순회하며 같은 이름 있는지 확인
      for(Fruit fruit: DBConnecter.fruits) {
//    	  (equals 메소드 사용) 과일의 이름이 일치한다면
         if(fruit.getName().equals(name)) {
            return fruit;	// 해당 과일 객체 반환
         }
      }
      return null;	// 없으면 null 반환
   }
   
//   과일 추가
//   화면(프론트엔드)에서 중복검사를 마친 데이터를 넘길거기 땜에 중복검사가 따로 필요없다
   public void save(Fruit fruit) {
//	   새로운 과일을 DB의 fruits 리스트에 추가
      DBConnecter.fruits.add(fruit);
   }
   
//   과일 삭제
   public void delete(Fruit fruit) {
//	   주어진 과일을 리스트에서 제거
//	   같은 객체가 리스트에 있으면 삭제, 없으면 아무 동작 안 함
      DBConnecter.fruits.remove(fruit);
   }
   
//   이름을 이용해 과일을 삭제
   public void delete(String name) {
//	   checkName을 호출하여 같은 이름의 과일 객체를 찾기
      Fruit fruit = checkName(name);
      
      if(fruit != null) {	// 객체를 찾으면
         DBConnecter.fruits.remove(fruit);	// 해당 객체를 삭제
      }
   }
   
//   과일 가격이 평균 가격보다 낮은 지 검사
//   입력한 과일의 가격이 평균 가격보다 낮으면 true 반환, boolean
   public boolean checkPrice(Fruit newFruit) {
      int total = 0;	// 가격 합계를 저장할 변수
      double average = 0.0;	// 가격 평균을 저장할 변수
      
//      빠른 for문: DB의 과일리스트를 순회
//      순회 대상: DBConnecter.fruits(과일(fruits)객체들이 저장된 리스트)
//      순회 변수: Fruit fruit(리스트의 처음~끝 요소까지 fruit 변수에 하나씩 할당)
      for(Fruit fruit: DBConnecter.fruits) {
//    	  순회 돈 과일들의 가격들을 모두 더하여 total 변수에 저장
         total += fruit.getPrice();
      }
      
//      평균 = total에 DB에 저장된 과일들의 개수(size)를 나누기
//      실수(double)로 저장
      average = (double)total / DBConnecter.fruits.size();
//      평균이 입력한 과일의 가격보다 큰지 true or false(boolean)로 리턴
      return average > newFruit.getPrice();
   }
   
//   과일 전체 조회
//   List<Fruit>는 인터페이스이다. 과일 객체(Fruit)들을 순서대로 저장할 수 있는 Collection
//   DBConnecter.fruits는 List<
   public List<Fruit> findAll(){
//	   DB에 저장된 fruits의 목록 반환
      return DBConnecter.fruits;
   }
   
//   과일 이름으로 가격 조회
   public int findPrice(String name) {
//	   이름 검사 메소드 checkName() 사용
      Fruit fruit = checkName(name);
      if(fruit != null) {	// 해당 과일이 존재하면
         return fruit.getPrice();	// 해당 과일의 가격 반환
      }
      return -1;	// 해당 과일이 없을 때
   }
}
















