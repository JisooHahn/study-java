package classTest;

public class AdCompany {

}
package classTest;

public class AdCompany {
   CategoryA[] arCategories;

   public AdCompany() {
      ;
   }

   public AdCompany(CategoryA[] arCategories) {
      this.arCategories = arCategories;
   }

   boolean sell(Client client, String categoryA, String categoryB, String categoryC) {
      int price = findCategory(categoryA, categoryB, categoryC);
      if(price != -1) {
         client.money -= price;
         return true;
      }
      return false;
   }

   int findCategory(String categoryA, String categoryB, String categoryC) {
      for (int i = 0; i < arCategories.length; i++) {
//         대카 같니?
         if (arCategories[i].name.equals(categoryA)) {
            for (int j = 0; j < arCategories[i].arCategoryB.length; j++) {
//               중카 같니?
               if (arCategories[i].arCategoryB[j].name.equals(categoryB)) {
                  for (int k = 0; k < arCategories[i].arCategoryB[j].arCategoryC.length; k++) {
//                     소카 같니?
                     if (arCategories[i].arCategoryB[j].arCategoryC[k].name.equals(categoryC)) {
//                        같네
                        return arCategories[i].arCategoryB[j].arCategoryC[k].price;
                     }
                  }
               }
            }
         }
      }
//      다르네
      return -1;
   }
}




