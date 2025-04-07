package threadTask;

public class Zoo {
   public static void main(String[] args) {
//      Animal resource = new Animal();
//      
//      Thread tiger = new Thread(resource, "어흥");
//      Thread cow = new Thread(resource, "무우");
//      Thread cat = new Thread(resource, "야옹");
//      
//      tiger.start();
//      cow.start();
//      
//      try {
//         tiger.join();
//         cow.join();
//      } catch (InterruptedException e) {;}
//
//      cat.start();
      
      new Animal().makeSound(() -> {
         for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {Thread.sleep(500);} catch (InterruptedException e) {;}
         }
      });
   }
}
