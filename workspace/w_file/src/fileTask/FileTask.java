package fileTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
   public static void main(String[] args) throws IOException {
//      생선 종류를 파일에 출력한 뒤
//      입력받은 내용을 모두 콘솔에 출력한다.
//      생선은 3마리다.
      final String PATH = "fish.txt";	// 텍스트 경로 지정

      String[] fishes = { "고등어", "삼치", "연어" };	// fishes를 저장하는 문자열 배열
//      
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH));
//      예외처리를 위한 초기값 설정
      BufferedReader bufferedReader = null;
      String line = null;

      for (int i = 0; i < fishes.length; i++) {
         bufferedWriter.write(fishes[i] + "\n");
      }

      bufferedWriter.close();

      try {
         bufferedReader = new BufferedReader(new FileReader(PATH));

         while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
         }

      } catch (FileNotFoundException e) {
         System.out.println("경로를 다시 확인하십시오.");
      } finally {
         bufferedReader.close();
      }

//      고등어를 감성돔로 변경
      String temp = "";

      try {
         bufferedReader = new BufferedReader(new FileReader(PATH));

         while ((line = bufferedReader.readLine()) != null) {

//            1. 고등어 찾기
            if (line.equals("고등어")) {
//               2. 고등어 대신 감성돔 넣기
               temp += "감성돔\n";
               continue;
            }

//            3. 고등어가 아니면 그대로 넣기
            temp += line + "\n";
         }

      } catch (FileNotFoundException e) {
         System.out.println("경로를 다시 확인하십시오.");
      } finally {
         bufferedReader.close();
      }

//      4. 완성된 문자열로 덮어쓰기
      bufferedWriter = new BufferedWriter(new FileWriter(PATH));
      bufferedWriter.write(temp);
      bufferedWriter.close();

//      감성돔 삭제하기
//      고등어를 감성돔로 변경
      temp = ""; // 출력전에 값들을 담을 임시 변수 생성

      try {
//    	 
         bufferedReader = new BufferedReader(new FileReader(PATH));

         while ((line = bufferedReader.readLine()) != null) {

//            1. 감성돔 찾기
//        	 reader로 읽은 텍스트 내용에 감성돔이 있으면
            if (line.equals("감성돔")) {
//               2. 고등어는 건너뛴다.
//            	temp에 저장하지 않고 continue로 건너뛴다.
               continue;
            }

//            2. 감성돔이 아니면 그대로 넣기
//            감성돔을 제외한 다른 생선들은 temp에 한 줄씩 추가한다.
            temp += line + "\n";
         }
//         경로를 찾을 수 없을 시
      } catch (FileNotFoundException e) {
         System.out.println("경로를 다시 확인하십시오.");
      } finally {	// 마지막에 반드시 실행됨
         bufferedReader.close();
      }

//      3. 완성된 문자열로 덮어쓰기
//    bufferedWriter 객체화(PATH에 저장)
      bufferedWriter = new BufferedWriter(new FileWriter(PATH));
//      temp에 들어있는 생선들의 값을 쓴다.
      bufferedWriter.write(temp);
//      닫는다.
      bufferedWriter.close();
   }

}
