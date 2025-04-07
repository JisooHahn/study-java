package list.task.fruit;

import java.util.Objects;

//	과일 정보를 저장할 클래스
public class Fruit {
//	과일 이름, 가격
	private String name;
	private int price;
	
//	생성자
	public Fruit() {;}

	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

//	getter & setter
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

//	equals랑 toString필요
	@Override
		public String toString() {
			// 객체의 정보를 알기 쉽게 문자열로 변환
			return "Fruit [name =" + name + ", price =" + price + "]";
		}
	
	@Override
//	두 Fruit 객체가 동일한지 비교할 때 name이 동일한지 확인
		public boolean equals(Object obj) {
			if(this == obj)	// 1.동일한 객체인지 비교
				return true;
			if(obj == null)	// 2.비교대상이 null이면 false
				return false;
			if(getClass() != obj.getClass())	// 3.Class 타입이 다르면 false
				return false;
			Fruit other = (Fruit) obj;	// 4. obj를 Fruit 타입으로 다운캐스팅
			return Objects.equals(name, other.name);	// 5. name 필드값이 동일하면 true 반환 
		}
	
}
