package classTest;

public class User {
   int id;
   String name;
   String email;
   String password;
   
   Profile[] arProfile;
   
   // 오버 로딩(Overloading)
   public User() {}

   public User(int id, String name, String email, String password, Profile[] arProfile) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.password = password;
      this.arProfile = arProfile;
   }
}