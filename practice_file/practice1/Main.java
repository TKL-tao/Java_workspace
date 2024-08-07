import myfirstpackage.Animal;
import myfirstpackage.Dog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

import mysecondpackage.LittleCat;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {
        // Runnable task = () -> {System.out.println("This is thread 1");};  // 这是thread1的run方法
        // Thread thread1 = new Thread(task, "My thread 1");
        // Main thread2 = new Main();
        // thread2.start();
        // thread1.start();
        // for (int i=0; i<10; i++) {
        //     System.out.println("Outside");
        //     Thread.sleep(10);
        // }
        int[][] intArr = {{1, 3, 4}, {5, 4, 1}};
        String[] stringArr = {"a", "c", "d"};
        System.out.println(Arrays.deepToString(intArr));
        System.out.println(Arrays.toString(stringArr));
    }

    // 这是thread2的run方法
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
