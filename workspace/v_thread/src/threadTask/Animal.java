package threadTask;

public class Animal/* implements Runnable */{
//   @Override
//   public void run() {
//      for (int i = 0; i < 10; i++) {
//         System.out.println(Thread.currentThread().getName());
//         try {Thread.sleep(500);} catch (InterruptedException e) {;}
//      }
//   }
   public void makeSound(Runnable runnable) {
      String[] arSound = {"어흥", "음메", "야옹"};
      Thread[] arThread = new Thread[arSound.length];
      
      for (int i = 0; i < arThread.length; i++) {
         arThread[i] = new Thread(runnable, arSound[i]);
      }
      
      for (int i = 0; i < arThread.length; i++) {
         arThread[i].start();
         if(i != 0) {
            try {arThread[i].join();} catch (InterruptedException e) {;}
         }
      }
   }
}















