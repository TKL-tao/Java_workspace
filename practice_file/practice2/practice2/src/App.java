import java.util.List;
import java.util.stream.Collectors;

public class App {

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                          .filter(x -> x.getType().equals(type))
                          .collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
