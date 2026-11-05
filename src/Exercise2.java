import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        File dir = new File("Ex2LuckyNumber");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of files: ");
        int num = input.nextInt();
        input.close();

        try {
            dir.delete();
            dir.mkdir();
            for (int i = 1; i <= num; i ++) {
                File file = new File("Ex2LuckyNumber/file" + i + ".csv");
                FileWriter writer = new FileWriter(file);
                for (int j = 0; j < 100; j ++) {
                    int random = (int) (Math.random() * 100) + 1;
                    writer.write(random + "\n");
                }
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
