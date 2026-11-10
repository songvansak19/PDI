/*
Write a program that can creates and runs multiple threads using Thread class.
Let’s define 3 functions to: 
a) find sum from 1 to n, 
b) show all prime numbers in between 1 to 100, 
c) read data from a CSV file of student list (name, ID, age, gender) 
and store it into an array list.
 */

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n number: ");
        int num = input.nextInt();
        input.close();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= num; i++)
                    System.out.println("Sum: " + (sum += i));
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 2; i <= 100; i++) {
                    boolean isPrime = true;
                    for (int j = 2; j < i; j++) {
                        if (i % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (i == 2 || i == 3)
                        System.out.println("Prime: " + i);
                    if (isPrime)
                        System.out.println("Prime: " + i);
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                List<List<String>> data = new ArrayList<>();
                try {
                    BufferedReader bReader = Files.newBufferedReader(
                            Path.of("CandidatePerformanceTest.csv"));
                    for (int i = 0; i < 3; i++)
                        bReader.readLine();
                    String line;
                    for (int i = 0; i < 100; i++) {
                        if ((line = bReader.readLine()) == null)
                            break;
                        data.add(Arrays.asList(line.split(",")));
                    }
                    bReader.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                data.stream().forEach(candidate -> {
                    System.out.println("ID: " + candidate.get(0)
                            + ", Group: " + candidate.get(2)
                            + ", Gender: " + candidate.get(1)
                            + ", Total Score: " + candidate.get(8));
                });
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
