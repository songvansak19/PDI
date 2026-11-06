import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args) {
        int number;
        double sum = 0, avg;
        System.out.println("Enter a number: ");

        try (Scanner input = new Scanner(System.in)) {
            number = input.nextInt();
        }

        System.out.println("Entered Number: " + number);
        for (int i = 1000; i >= number; i --) {
            sum += i;
            System.out.println(i);
        }
        avg = sum / (1000 - number + 1);
        System.out.println("Sum is: " + sum);
        System.out.println("Average is: " + avg);
    }
}
