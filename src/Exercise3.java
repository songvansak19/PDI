import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Exercise3 {
    public static void FileUpdate(Path path, String string) {
        try {
            String data = Files.readString(path);
            data += string;
            Files.writeString(path, data);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Path path = Path.of("Ex3StudentData.csv");
        Scanner input = new Scanner(System.in);

        try {
            for (int i = 0; i < 3; i ++) {
                System.out.println("+ Student " + (i + 1) + ":");
                System.out.print("Enter Your Name: ");
                String name = input.nextLine();
                System.out.print("Enter Your ID: ");
                String id = input.nextLine();
                System.out.print("Enter Your Gender: ");
                String gender = input.nextLine();
                
                String string = name + "," + id + "," + gender + "\n";
                FileUpdate(path, string);
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
