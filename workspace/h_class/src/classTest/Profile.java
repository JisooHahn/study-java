package classTest;

public class Profile {
   String path;
   String fileName;
   int fileSize;
   boolean check;
   
   public Profile() {}

   public Profile(String path, String fileName, int fileSize, boolean check) {
      this.path = path;
      this.fileName = fileName;
      this.fileSize = fileSize;
      this.check = check;
   }
}
