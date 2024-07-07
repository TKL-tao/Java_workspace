import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class File_handling {
  public static void main(String[] args) {
    File myObj = null;

    try {
      myObj = new File("myfirstfile.txt");
      if (myObj.createNewFile()) {
        System.out.println("File cretead: " + myObj.getName());
        System.out.println("File is at directory: " + myObj.getAbsolutePath());
      } else {
        System.out.println("File already existed.");
      }
    } catch (IOException e) {  // This try-catch structure is neccssary.
      System.out.println("An error occurred");
      e.printStackTrace();
    }

    try {
      FileWriter myWriter = new FileWriter("myfirstfile.txt");
      myWriter.write("Files in Java might be tricky.\nLine2\nLine3\nLine4");  // Overridding write.
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {  // This try-catch structure is neccssary.
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    try {
      Scanner myReader = new Scanner(myObj);
      System.out.println("Begin to read and output " + myObj.getName() + "'s content:");
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    // Get file information
    if (myObj.exists()) {
      System.out.println("Below are file's information:");
      System.out.println(myObj.getName());
      System.out.println(myObj.AbsolutePath());
      System.out.println(myObj.canWrite());
      System.out.println(myObj.CanRead());
      System.out.println(myObj.length());
    } else {
      System.out.println("The file doesn't exist.");
    }
  }
}