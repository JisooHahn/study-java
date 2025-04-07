package list.task;

import java.util.ArrayList;

import list.task.fruit.Fruit;
import list.task.product.Product;
import list.task.user.User;
import list.task.food.Food;


//	메모리에 사용자 데이터를 저장하는 역할을 한다.
public class DBConnecter {
//	생성자(protected)
   protected DBConnecter() {;}
//   사용자 리스트(정적 필드)
//   모든 User 객체를 저장하는 리스트 역할
//   users 덕분에 모든 곳에서 데이터 공유가 가능하다.
    public static ArrayList<User> users = new ArrayList<User>();
//	과일 리스트(ArrayList)
	public static ArrayList<Fruit> fruits = new ArrayList<Fruit>();
//	음식 리스트
	public static ArrayList<Food> foods = new ArrayList<Food>();
//	상품 리스트
	public static ArrayList<Product> products = new ArrayList<Product>();
}


