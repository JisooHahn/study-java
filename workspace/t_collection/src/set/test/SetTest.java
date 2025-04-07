package set.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
   public static void main(String[] args) {
//      HashSet<String> bloodTypeSet = new HashSet<String>();
//      
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("B");
//      bloodTypeSet.add("O");
//      bloodTypeSet.add("AB");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      
//      System.out.println(bloodTypeSet.toString());
      
//      중복 제거
//      ArrayList<String> userBloodTypes = new ArrayList<String>();
//      HashSet<String> blooTypeHashSet = null; 
//      
//      userBloodTypes.add("A");
//      userBloodTypes.add("B");
//      userBloodTypes.add("O");
//      userBloodTypes.add("AB");
//      userBloodTypes.add("A");
//      userBloodTypes.add("A");
//      userBloodTypes.add("O");
//      userBloodTypes.add("O");
//      userBloodTypes.add("AB");
//      userBloodTypes.add("A");
//      
//      System.out.println(userBloodTypes);
//      
//      blooTypeHashSet = new HashSet<String>(userBloodTypes);
//      System.out.println(blooTypeHashSet);
//      
//      userBloodTypes = new ArrayList<String>(blooTypeHashSet);
//      System.out.println(userBloodTypes);
      
      
//      HashSet<String> bloodTypeSet = new HashSet<String>();
//      Iterator<String> bloodIter = null;
//      
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("B");
//      bloodTypeSet.add("O");
//      bloodTypeSet.add("AB");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      bloodTypeSet.add("A");
//      
//      bloodIter = bloodTypeSet.iterator();
//      
//      while(bloodIter.hasNext()) {
//         System.out.println(bloodIter.next());
//      }
      
      HashSet<Member> memberSet = new HashSet<Member>();
      
      memberSet.add(new Member(1L, "test1@gmail.com", "1234"));
      memberSet.add(new Member(2L, "test2@gmail.com", "4321"));
      memberSet.add(new Member(3L, "test3@gmail.com", "5678"));
      System.out.println(memberSet);

      memberSet.add(new Member(1L, "test1@gmail.com", "1234"));
      System.out.println(memberSet.size());
   }
}


















