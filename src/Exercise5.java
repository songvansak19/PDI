import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5 {
    public static void addStudent(Path path, String string) {
        try {
            if (!Files.exists(path))
                Files.writeString(path, "Name,Student ID,Gender");
            String array = Files.readString(path);
            array += string;
            Files.writeString(path, array);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<String[]> getData(Path path, List<String[]> students) {
        // Read the database and store into an Array list of Stduents.
        try {
            if (!Files.exists(path))
                Files.writeString(path, "Name,Student ID,Gender");
            BufferedReader bReader = Files.newBufferedReader(path);
            bReader.readLine(); // Call 'readLine()' to Skip the Header in the database.

            while (true) {
                String line = bReader.readLine();
                if (line == null)
                    break;
                students.add(line.split(","));
            }
            bReader.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return students;
    }

    public static List<String[]> sortName(Path path) {
        List<String[]> students = new ArrayList<>();
        // Get the Updated data first then, sort those data by name.
        students = getData(path, students)
                .stream()
                .sorted((rowA, rowB) -> rowA[0].compareToIgnoreCase(rowB[0]))
                .toList();
        // Write back to the database.
        try {
            BufferedWriter bWriter = Files.newBufferedWriter(path);
            bWriter.write("Name,Student ID,Gender");
            bWriter.newLine();
            for (String[] student : students) {
                bWriter.write(student[0] + "," + student[1] + "," + student[2]);
                bWriter.newLine();
            }
            bWriter.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return students;
    }

    public static void main(String[] args) {
        Path path = Path.of("Ex3StudentData.csv");
        List<String[]> students = new ArrayList<>();

        students = getData(path, students);
        students = sortName(path);

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("\n\nStudent Sort by Name");
            System.out.println("=".repeat(65));
            for (String[] student : students) {
                System.out.printf("Name: %-20s ID: %-20s Gender: %s\n", student[0], student[1], student[2]);
            }
            System.out.println("=".repeat(65) + "\n");

            for (int i = 0; i < 3; i++) {
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
            students = sortName(path);

            System.out.println("\n\nStudent Sort by Name");
            System.out.println("=".repeat(65));
            for (String[] student : students) {
                System.out.printf("Name: %-20s ID: %-20s Gender: %s\n", student[0], student[1], student[2]);
            }
            System.out.println("=".repeat(65) + "\n");

            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
