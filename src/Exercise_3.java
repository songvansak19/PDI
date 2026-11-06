import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_3 {
    public static void main(String[] args) {
        int min, max;
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter 5 numbers below: ");

        try (Scanner input = new Scanner(System.in)) {
            for (int i = 0; i < 5; i ++) {
                System.out.print("Number " + (i + 1) + ": ");
                numbers.add(input.nextInt());
            }
        }

        min = numbers.get(0);
        max = numbers.get(0);

        for (int i = 0; i < numbers.size(); i ++) {
            if (min >= numbers.get(i)) {min = numbers.get(i);}
            if (max <= numbers.get(i)) {max = numbers.get(i);}
        }

        System.out.print("Among all the five input numbers " + numbers);
        System.out.print(", min is " + min + " and max is " + max + ".");
    }
}
