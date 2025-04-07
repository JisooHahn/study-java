package staticTest;

public class Company {
//   인스턴스 변수
   String name;
   int income;
   
//   클래스 변수
   static int totalIncome;
   
   public Company() {;}

   public Company(String name, int income) {
      this.name = name;
      this.income = income;
   }
}
