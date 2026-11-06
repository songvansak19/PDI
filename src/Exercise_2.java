import java.util.Scanner;

public class Exercise_2 {
    public static void main(String[] args) {
        int a, b, c;
        double x1, x2;

        System.out.println("=".repeat(41));
        System.out.println("Welcome to our Program");
        System.out.println("'Quadratic Equation Solver ax^2 + bx + c'");
        System.out.println("=".repeat(41));

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input a: ");
            a = input.nextInt();
            System.out.print("Input b: ");
            b = input.nextInt();
            System.out.print("Input c: ");
            c = input.nextInt();
        }

        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta == 0 || a == 0) {
            x1 = - (double) c / (double) b;
            System.out.println("The root of the Equation is: " + x1);
        }
        else if (delta >= 0) {
            x1 = (- b + Math.sqrt(delta)) / (2 * a);
            x2 = (- b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Roots of the equation: (" + a + ")x^2 + (" + b + ")x + (" + c + ") are: ");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        else {
            double p = (double) b / (2 * (double) a);
            double q = Math.sqrt(- delta) / (2 * a);

            System.out.println("the roots of the Equation is:");
            System.out.println(p + " - " + q + "i");
            System.out.println(p + " + " + q + "i");
        }
    }
}
