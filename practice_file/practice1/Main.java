import myfirstpackage.Animal;
import myfirstpackage.Dog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println(animal.getCategory());

        Animal dog = new Dog();
        System.out.println(dog.getCategory());
        // System.out.println(dog.dogSound);

        Dog myDog = new Dog();
        System.out.println(myDog.dogSound);


        char[] myChars = {'a', 'b', 'c', 'd'};
        String myString = String.valueOf(myChars);
        System.out.println(myString);
    }
}
