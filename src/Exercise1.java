import java.io.File;
import java.io.FileWriter;

public class Exercise1 {
    public static void main(String[] args) throws Exception {
        File file = new File("LuckyNumber.csv");
        FileWriter writer = new FileWriter(file);
        for (int i = 1; i <= 500; i ++) {
            int random = (int) (Math.random() * 100);
            writer.write("Lucky Number " + i +": " + random + "\n");
        }
        writer.close();
    }
}
