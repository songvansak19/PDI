import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise6 {
    public static void clearScreen() {System.out.print("\033[H\033[2J");}
    public static List<List<String>> getData(Path path) {
        List<List<String>> data = new ArrayList<>();
        try {
            BufferedReader bReader = Files.newBufferedReader(path);
            for (int i = 0; i < 3; i++) bReader.readLine();
            while (true) {
                String line = bReader.readLine();
                if (line == null) break;
                List<String> columns = Arrays.asList(line.split(","));
                data.add(columns);
            }
            bReader.close();
            return data;
        } catch (Exception e) {System.out.println("File not found!");}
        return null;
    }
    public static void main(String[] args) {
        clearScreen();
        Path path = Path.of("CandidatePerformanceTest.csv");
        List<List<String>> data = getData(path);
        if (data == null) return;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("1 - Total Candidates");
            System.out.println("2 - Candidate with score above 90% ");
            System.out.println("3 - Each Subject with score atleast 85%");
            System.out.println("4 - Students in each group");
            System.out.println("5 - Exit the program");
            System.out.print("Your Option: ");
            String str = input.nextLine();
            int opt;
            try {
                opt = Integer.parseInt(str);
            } catch(Exception e) {
                clearScreen();
                System.out.println("Invalid Option!!");
                System.out.println("=".repeat(30));
                continue;
            }
            switch (opt) {
                case 1 -> {
                    clearScreen();
                    long maleCounts = data.stream().filter(candidate -> candidate.get(1).equals("male")).count();
                    System.out.printf("Total Candidates: %d\n", data.size());
                    System.out.printf("- Male: %.2f%% of total candidates\n", (maleCounts / (double) data.size() * 100));
                    System.out.printf("- Female: %.2f%% of total candidates\n", (1 - maleCounts / (double) data.size()) * 100);
                    break;
                }
                case 2 -> {
                    clearScreen();
                    long[] genderCounts = new long[2];
                    data.stream().filter(candidate -> Double.parseDouble(candidate.get(9)) >= 90).forEach(candidate -> {
                        if (candidate.get(1).equals("male")) genderCounts[0] ++;
                        else genderCounts[1] ++;
                    });
                    System.out.printf("Ttoal Cadidates: %d\n", genderCounts[0] + genderCounts[1]);
                    System.out.printf("- Male: %.2f%% of total candidates\n", genderCounts[0] / (double) data.size() * 100);
                    System.out.printf("- Female: %.2f%% of total candidates\n", genderCounts[1] / (double) data.size() * 100);
                    break;
                }
                case 3 -> {
                    clearScreen();
                    long[] genderCounts = new long[2];
                    data.stream()
                            .filter(candidate -> candidate.subList(5, 8)
                                    .stream()
                                    .map(score -> Integer.parseInt(score))
                                    .allMatch(score -> score >= 85)
                            )
                            .forEach(candidate -> {
                                if (candidate.get(1).equals("male")) genderCounts[0] ++;
                                else genderCounts[1] ++;
                            });
                    System.out.printf("Ttoal Candidates: %d\n", genderCounts[0] + genderCounts[1]);
                    System.out.printf("- Male: %.2f%% of total candidates\n", genderCounts[0] / (double) data.size() * 100);
                    System.out.printf("- Female: %.2f%% of total candidates\n", genderCounts[1] / (double) data.size() * 100);
                    break;
                }
                case 4 -> {
                    clearScreen();
                    int[] groups = new int[5];
                    long genderCounts[][] = new long[5][2];
                    data.stream().forEach(candidate -> {
                        int group = (char) candidate.get(2).charAt(candidate.get(2).length() - 1);
                        groups[group - 65] ++;
                        if (candidate.get(1).equals("male")) genderCounts[group - 65][0] ++;
                        else genderCounts[group - 65][1] ++;
                    });
                    for (int i = 0; i < 5; i ++) {
                        System.out.println("Group " + (char) (65 + i) + ": " + groups[i] + " Candidate(s)");
                        System.out.printf("- Male: %.2f%%\n", genderCounts[i][0] / (double) groups[i] * 100);
                        System.out.printf("- Female: %.2f%%\n", genderCounts[i][1] / (double) groups[i] * 100);
                    }
                    break;
                }
                case 5 -> {
                    clearScreen();
                    System.out.println("\nGoodbye!!");
                    input.close();
                    return;
                }
                default -> {
                    clearScreen();
                    System.out.println("Invalid Option!!");
                    break;
                }
            }
            System.out.println("=".repeat(30));
        }
    }
}