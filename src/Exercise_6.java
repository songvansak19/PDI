import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_6 {
    public static void main(String[] args) {
        double min, max, average = 0;
        ArrayList <Double> scores = new ArrayList<>(); // Dynamic Array.
        String[] subjects = {"Math", "English", "Physics", "Programming"}; // Fixed Array.

        System.out.println("Input your scores of 4 subjects:");
        try (Scanner input = new Scanner(System.in)) {
            for (String subject : subjects) {
                System.out.print(subject + ": ");
                scores.add(input.nextDouble());
            }
        }
        min = scores.get(0);
        max = scores.get(0); 
        for (double score : scores) {
            average += score;
            if (min >= score) min = score;
            if (max <= score) max = score;
        }

        System.out.print("\nMax score is: " + max + " (");
        for (int i = 0; i < subjects.length; i ++) {
            if (scores.get(i) == max) {
                System.out.print(subjects[i] + " ");
            }
        }
        System.out.println("course(s))");

        System.out.print("Min score is: " + min + " (");
        for (int i = 0; i < subjects.length; i ++) {
            if (scores.get(i) == min) {
                System.out.print(subjects[i] + " ");
            }
        }
        System.out.println("course(s))");
        System.out.println("Average score of the student is: " + average / scores.size());
    }
}
