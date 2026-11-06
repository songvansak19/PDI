import java.util.Scanner;

public class Exercise_4 {
    public static void main(String[] args) {
        String date;
        boolean isValid = false;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter yyyy-mm-dd: ");
            date = input.nextLine();
            input.close();

            if (date.length() == 10 && date.charAt(4) == '-' && date.charAt(7) == '-') {
                try {
                    int month = Integer.parseInt(date.substring(5, 7));
                    int day = Integer.parseInt(date.substring(8, 10));
                    isValid = (month > 0 && month < 13) && (day > 0 && day < 32);
                } catch (Exception error_msg) {
                    isValid = false;
                }
            } 
            else {
                isValid = false;
            }

            if (isValid) {
                System.out.println("Valid Date!");
                break;
            }
            System.out.println("Invalid Date!");
        }
    }
}
