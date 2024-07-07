record Greeting(long id, String content) {}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting(256, "Hello, World.");
        System.out.println(greeting.id() + " " + greeting.content());
    }
}