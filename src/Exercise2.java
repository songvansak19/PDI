import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Calculator");
            System.out.println("1 - Sum");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiplication");
            System.out.println("4 - Division");
            System.out.println("5 - Sum from 1 to n");
            System.out.println("6 - Exit");
            System.out.print("Yout option: ");
            int option = input.nextInt();
            switch (option) {
                case 1 -> {
                    double a, b;
                    System.out.print("Enter number a: ");
                    a = input.nextDouble();
                    System.out.print("Enter number b: ");
                    b = input.nextDouble();
                    System.out.println(a + " + " + b + " = " + (a + b)) ;
                }
                case 2 -> {
                    double a, b;
                    System.out.print("Enter number a: ");
                    a = input.nextDouble();
                    System.out.print("Enter number b: ");
                    b = input.nextDouble();
                    System.out.println(a + " - " + b + " = " + (a - b)) ;
                }
                case 3 -> {
                    double a, b;
                    System.out.print("Enter number a: ");
                    a = input.nextDouble();
                    System.out.print("Enter number b: ");
                    b = input.nextDouble();
                    System.out.println(a + " x " + b + " = " + (a * b)) ;
                }
                case 4 -> {
                    double a, b;
                    System.out.print("Enter number a: ");
                    a = input.nextDouble();
                    System.out.print("Enter number b: ");
                    b = input.nextDouble();
                    System.out.println(a + " / " + b + " = " + (a / b)) ;
                }
                case 5 -> {
                    int n, sum = 0;
                    System.out.print("Enter number n: ");
                    n = input.nextInt();
                    for (int i = 1; i <= n; i ++) sum += i;
                    System.out.println("Sum from 1 to " + n + " is: " + sum);
                }
                case 6 -> running = false;
                default -> System.out.println("Invalid Option!");
            }
        }
        System.out.println("Goodbye!!");
    }
}
