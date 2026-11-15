import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Exercise10 {
    private static final Path CSV_FILE = Path.of("students.csv");

    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(CSV_FILE)) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] fields = line.split(",", -1);
                if (firstLine && fields[0].trim().equalsIgnoreCase("name")) {
                    firstLine = false;
                    continue;
                }
                firstLine = false;
                if (fields.length > 0 && !fields[0].trim().isEmpty()) {
                    studentNames.add(fields[0].trim());
                }
            }

            System.out.println("Student names in A-Z order:");
            studentNames.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Could not read " + CSV_FILE
                    + ". Add a CSV with a name column (for example: name,ID,age,gender).");
        }
    }
}
