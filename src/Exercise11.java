import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise11 {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 3, 8};
        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Minimum: " + IntStream.of(numbers).min().getAsInt());
        System.out.println("Maximum: " + IntStream.of(numbers).max().getAsInt());
    }
}
