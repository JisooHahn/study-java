package staticTest;

public class GangNam {
   public static void main(String[] args) {
      Company 박정근 = new Company("박정근", 0);
      Company 김승균 = new Company("김승균", 0);
      Company 정도영 = new Company("정도영", 0);
      
      박정근.income += 3000;
      김승균.income -= 1000;
      정도영.income = 0;
      
      Company.totalIncome += 박정근.income + 김승균.income + 정도영.income;
      System.out.println(Company.totalIncome);
//      박정근.totalIncome += 박정근.income + 김승균.income + 정도영.income;
//      김승균.totalIncome += 박정근.income + 김승균.income + 정도영.income;
//      System.out.println(박정근.totalIncome);
//      System.out.println(김승균.totalIncome);
//      System.out.println(정도영.totalIncome);
   }
}










