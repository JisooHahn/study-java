package list.task.fruit;

import list.task.DBConnecter;

public class Page {
	public static void main(String[] args) {
		Market market = new Market();	// 새로운 market 객체 생성
		Fruit fruit = new Fruit();		// 새로운 Fruit 객체 생성

		
//		과일 추가
//		market에 fruit 객체가 없으면(값이 null이면)
		if(market.checkName(fruit.getName()) == null) {
//			fruit의 이름을 사과로 설정
			fruit.setName("사과");
//			fruit의 가격을 5000으로 설정
			fruit.setPrice(5000);
			
			market.save(fruit);	// 설정한 과일 객체를 market에 저장
		}
		
//		과일 삭제
//		market에 해당 fruit의 이름이 존재한다면(null이 아니면)
		if(market.checkName(fruit.getName()) != null) {
			market.delete(fruit);	// market에서 해당 fruit 삭제
		}
	}
}
