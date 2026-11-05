import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5 {
    public static void addStudent(Path path, String string) {
        try {
            if (!Files.exists(path)) Files.writeString(path, "Name,Student ID,Gender");
            else {
                String array = Files.readString(path);
                array += string;
                Files.writeString(path, array);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<String[]> sortName(Path path, List<String[]> students) {
        try {
            BufferedReader bReader = Files.newBufferedReader(path);
            bReader.readLine(); // Skip the Header

            while (true) {
                String line = bReader.readLine();
                if (line == null) break;
               students.add(line.split(","));
            }
            bReader.close();
            students.sort((rowA, rowB) -> rowA[0].compareToIgnoreCase(rowB[0]));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return students;
    }
    public static void main(String[] args) {
        Path path = Path.of("Ex3StudentData.csv");
        List<String[]> students = new ArrayList<>();

        students = sortName(path, students);

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("\n\nStudent Sort by Name");
            System.out.println("=".repeat(60));
            for (String[] student : students) {
                System.out.println("name: " + student[0] + "\t\t ID: " + student[1] + "\t\t Gender: " + student[2]);
            }
            System.out.println("=".repeat(60) + "\n");

            for (int i = 0; i < 3; i ++) {
                System.out.println("+ Student " + (i + 1) + ":");
                System.out.print("Enter Your Name: ");
                String name = input.nextLine();
                System.out.print("Enter Your ID: ");
                String id = input.nextLine();
                System.out.print("Enter Your Gender: ");
                String gender = input.nextLine();

                String newStudent = name + "," + id + "," + gender + "\n";
                addStudent(path, newStudent);
            }
            students = sortName(path, students);

            System.out.println("\n\nStudent Sort by Name");
            for (String[] student : students) {
                System.out.println("name: " + student[0] + "\t\t ID: " + student[1] + "\t\t Gender: " + student[2]);
            }
            System.out.println("=".repeat(60) + "\n");

            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
