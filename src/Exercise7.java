/*Write a program that reads CSV data (see attached link).
Create some methods that can answer the questions below:
Questions: How many students in each group? Percentage of male candidates ?
Percentage of female candidates?
a)-Then write students to different 4 CSV files based on their groups.
b)-Add a summary total students, %male and %female at the bottom of each file */

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise7 {
    public static List<List<String>> getData(Path path, Path outputDir) {
         List<List<String>> data = new ArrayList<>();
        try {
            if (!Files.exists(outputDir))Files.createDirectory(outputDir);
            BufferedReader bReader = Files.newBufferedReader(path);
            for (int i = 0; i < 3; i ++) bReader.readLine();
            while (true) {
                String line = bReader.readLine();
                if (line == null) break;
                data.add(Arrays.asList(line.split(",")));
            }
            return data;
        } catch (Exception e) {System.out.println("\nData not Found!!"); return null;}
    }
    public static String writer(List<String> candidate) {
        String line = new String();
        for (int i = 0; i < 10; i ++) line += candidate.get(i) + ",";
        line += "\n";
        return line;
    }
    public static void main(String[] args) {
        Path path = Path.of("CandidatePerformanceTest.csv");
        Path outputDir = Path.of("Ex7GroupsOutput");

        List<List<String>> data = getData(path, outputDir);
        if (data == null) return;

        long[] groups = new long[5];
        long[][] genderCounts = new long[5][2];

        data.stream().forEach(candidate -> {
            int group = candidate.get(2).charAt(candidate.get(2).length() - 1);
            Path groupPath = Path.of("Ex7GroupsOutput/Group " + (char) group + ".csv");
            try {
                Files.writeString(groupPath,
                    "List of candidates with the test scores "
                    + "(Group " + (char) group + "),,,,,,,,,\n"
                    + "ID,gender,group,Education,test preparation course,Math,English,Computer,Total,Average\n",
                    StandardOpenOption.CREATE);
                Files.writeString(groupPath, writer(candidate), StandardOpenOption.APPEND);}
            catch (Exception e) {System.out.println(e);}
            groups[group - 65] ++;
            genderCounts[group - 65][candidate.get(1).equals("male") ? 0 : 1] ++;
        });

        for (int i = 0; i < 5; i ++) {
            Path groupPath = Path.of("Ex7GroupsOutput/Group " + (char) (65 + i) + ".csv");
            String male = String.format("Male: %.2f%%\n", (genderCounts[i][0] / (double) groups[i] * 100)),
            female = String.format("Female: %.2f%%\n", (genderCounts[i][1] / (double) groups[i] * 100));
            try {
                Files.writeString(
                    groupPath,
                    "\nTotal Candidates: " + groups[i] + "\n" + male + female,
                    StandardOpenOption.APPEND);
            } catch (Exception e) {System.out.println(e);}
        }
        System.out.println("\n> Ouput Groups/ is created!");
    }
}
