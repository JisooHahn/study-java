package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
   public static void main(String[] args) throws IOException{
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
//      bufferedWriter.write("라멘\n");
////      bufferedWriter.newLine();
//      bufferedWriter.close();
      
      BufferedReader bufferedReader = null;
      String line = null;
      
      try {
         bufferedReader = new BufferedReader(new FileReader("test.txt"));
         while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
         }
      } catch (FileNotFoundException e) {
         System.out.println("경로를 다시 확인바랍니다.");
      }
      
      bufferedReader.close();
   }
}


















