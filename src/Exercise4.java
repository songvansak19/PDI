import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise4 {
    public static void main(String[] args) {
        Path path = Path.of("Ex3StudentData.csv");
        try {
            String[] data = Files.readString(path).split(",");
            for (String item : data) {
                System.out.print(item + "\t\t\t| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
