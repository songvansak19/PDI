/*Write a program that reads CSV data (see attached link).
Create some methods that can answer the questions below:
Questions: How many students in each group? Percentage of male candidates ?
Percentage of female candidates?
a)-Then write students to different 4 CSV files based on their groups.
b)-Add a summary total students, %male and %female at the bottom of each file */

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise7 {
    public static List<List<String>> getData(Path path) {
         List<List<String>> data = new ArrayList<>();
        try {
            BufferedReader bReader = Files.newBufferedReader(path);
            for (int i = 0; i < 3; i ++) bReader.readLine();
            while (true) {
                String line = bReader.readLine();
                if (line == null) break;
                data.add(Arrays.asList(line.split(",")));
            }
        } catch (Exception e) {System.out.println("File not Found!!"); return null;}
        return data;
    }
    public static void main(String[] args) {
        Path path = Path.of("CandidatePerformanceTest.csv");
        List<List<String>> data = getData(path);
        
    }
}
