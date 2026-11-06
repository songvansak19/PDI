import java.util.Scanner;

public class Exercise_5 {
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i ++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String Input;
        System.out.print("Enter n number: ");

        try (Scanner input = new Scanner(System.in)) {
            Input = input.nextLine();
        }

        try {
            int number = Integer.parseInt(Input);
            if (number >= 2) {
                System.out.println("All prime numbers from 2 to " + number + ": ");
                for (int i = 2; i <= number; i ++) {
                    if (isPrime(i)) {
                        System.out.println(i);
                    }
                }
            }
            else {
                System.out.println("Number must be greater or equal to 2!");
            }
        }
        catch (NumberFormatException error_msg) {
            System.out.println("Invalid Number!");
        }
    }
}