package classTest;

// 카테고리
// 대카 안에 중카, 중카 안에 소카
// 대카 N개, 중카 N개, 소카 N개

// 광고 회사
// 카테고리 목록(배열), 가격
// 판매하기 메소드
// 광고주가 신천한 광고 카테고리와 광고 회사의 카테고리가 일치하면 판매

// 광고주
// 회사명, 잔고
public class ClassTask05 {
   public static void main(String[] args) {
//      1차원 배열, 소카테고리 담는 배열
      CategoryC[] arBC1 = {
            // 소카테고리 초기화 생성자
            // 1. 카테고리 이름
            // 2. 가격
            // 소카테고리는 하위 카테고리가 없기 때문에 카테고리 이름과 가격만 전달하여 초기화한다.
            new CategoryC("패턴", 5000),
            new CategoryC("무지", 8000),
            new CategoryC("단색", 2000)
      };
      
      CategoryC[] arBC2 = {
            new CategoryC("7부", 4000),
            new CategoryC("8부", 9000),
            new CategoryC("슬랙스", 10000)
      };
      
      CategoryB[] arAB = {
            new CategoryB("셔츠", arBC1),
            new CategoryB("바지", arBC2)
      };
      
      CategoryA[] arA = {
            new CategoryA("겨울", arAB),
            new CategoryA("여름", arAB)
      };
      
      AdCompany musinsa = new AdCompany(arA);
      Client ted = new Client("코리아IT", 50000);
      
      if(musinsa.sell(ted, "겨울", "장갑", "눈송이")) {
         System.out.println("광고 구매 성공!");
         System.out.println(ted.money);
      }else {
         System.out.println("다른 광고회사를 찾으세요!");
      }
      
   }
}












