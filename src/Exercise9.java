import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, -1, 3, -8, 20, -50);

        List<Integer> cubes = numbers.stream()
                .map(number -> number * number * number)
                .collect(Collectors.toList());
        System.out.println("Cubes: " + cubes);

        List<Integer> positiveNumbers = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
        System.out.println("Positive numbers: " + positiveNumbers);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);
    }
}
