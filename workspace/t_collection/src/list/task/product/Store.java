package list.task.product;

import java.util.List;

import list.task.DBConnecter;

public class Store {
	
//	상품 추가
	public void add(Product product) {
//		DB에 있는 products 리스트에 입력받은 product 추가
		DBConnecter.products.add(product);
	}
	
//	상품 조회
//	상품마다 고유한 name이 있으니 name으로 반복을 돌려서 
	public Product checkName(String name) {
		for(Product product : DBConnecter.products) {
//			product의 이름이 입력한 name과 일치한다면
			if(product.getName().equals(name)) {
				return product;	// 객체의 정보 반환
			}
		}
		return null;	// 해당 객체가 없으면 null 반환
	}
	
//	상품 목록
//	리스트를 가져오면 될거같다.
	public List<Product> findAll(){
		return DBConnecter.products;
	}
	
//	상품 수정
//	상품이 있는지 조회를 하여 그 상품 정보를 교체
	public void update(Product newProduct) {
		for(Product product : DBConnecter.products) {
//			입력한 상품의 이름이 있다면
			if(product.getName().equals(newProduct.getName())) {
				product.setPrice(newProduct.getPrice());
			}
		}
	}
	
//	상품 삭제
	public void delete(Product product){
//		DB에 products 리스트에서 입력한 상품 제거
		DBConnecter.products.remove(product);
	}
}
