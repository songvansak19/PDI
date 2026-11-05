import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new File("Ex3StudentData.csv");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Name,Student ID,Gender\n");
            for (int i = 0; i < 3; i ++) {
                System.out.println("+ Student " + (i + 1) + ":");
                System.out.print("Enter Your Name: ");
                String name = input.nextLine();
                System.out.print("Enter Your ID: ");
                String id = input.nextLine();
                System.out.print("Enter Your Gender: ");
                String gender = input.nextLine();
                
                writer.write(name + "," + id + "," + gender + "\n");
            }
            input.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
