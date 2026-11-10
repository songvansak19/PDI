import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n number: ");
        int num = input.nextInt();
        input.close();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= num; i ++) 
                    System.out.println("Sum: " + (sum += i));
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 2; i <= 100; i++) {
                    boolean isPrime = true;
                    for (int j = 2; j < i; j++) {
                        if (i % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (i == 2 || i == 3)
                        System.out.println("Prime: " + i);
                    if (isPrime) System.out.println("Prime: " + i);
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
