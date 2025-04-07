package list.task.product;

import java.util.Objects;

//	상품 클래스
public class Product {
//	상품명(중복되지 않음)
	private String name;
//	가격
	private int price;
//	재고
	private int stock;
	
//	생성자 만들기
	public Product() {;}

	public Product(String name, int price, int stock) {
	super();
	this.name = name;
	this.price = price;
	this.stock = stock;
}
//	getter, setter

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

//	tostring
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

	
//	equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && price == other.price && stock == other.stock;
	}
}
