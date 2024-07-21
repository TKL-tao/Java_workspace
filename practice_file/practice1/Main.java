import myfirstpackage.Animal;
import myfirstpackage.Dog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {System.out.println("This is thread 1");};
        Thread thread1 = new Thread(task, "My thread 1");
        Main thread = new Main();
        thread.start();
        thread1.start();
        for (int i=0; i<10; i++) {
            System.out.println("Outside");
            Thread.sleep(10);
        }
    }

    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("Inside");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
