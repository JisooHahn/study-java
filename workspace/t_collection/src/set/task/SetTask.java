package set.task;

import java.util.HashSet;

public class SetTask {
   public static void main(String[] args) {
//      태극기 색깔
//      흰색, 검은색, 빨간색, 파란색
      
//      각 색상을 Color 객체에 담은 뒤 HashSet에 담는다.
//      흰색을 한 번 더 담은 뒤 결과를 확인하고 hashCode()를 이해한다.
      
      HashSet<Color> colorSet = new HashSet<Color>();
      
      colorSet.add(new Color(1L, "흰색"));
      colorSet.add(new Color(2L, "검은색"));
      colorSet.add(new Color(3L, "빨간색"));
      colorSet.add(new Color(4L, "파란색"));
      System.out.println(colorSet);
      
      colorSet.add(new Color(1L, "흰색"));
      System.out.println(colorSet.size());
   }
}














