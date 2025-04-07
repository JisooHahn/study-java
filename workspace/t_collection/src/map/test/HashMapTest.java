package map.test;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		
		userMap.put("id", 1);
		userMap.put("email", "test@gmail.com");
		userMap.put("password", "1234");
		userMap.put("age", 20);
		System.out.println(userMap);
		
		userMap.put("email", "updated@naver.com");
		System.out.println(userMap);
		
		System.out.println(userMap.get("email"));
	}
}
