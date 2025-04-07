package set.test;

import java.util.Objects;

public class Member {
   private Long id;
   private String email;
   private String password;
   
   public Member() {;}

   public Member(Long id, String email, String password) {
      super();
      this.id = id;
      this.email = email;
      this.password = password;
   }
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "Member [id=" + id + ", email=" + email + ", password=" + password + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Member other = (Member) obj;
      return Objects.equals(id, other.id);
   }
}












