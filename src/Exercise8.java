import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise8 {
    private static final Path STUDENT_CSV = Path.of("students.csv");

    private static class Student {
        final String name;
        final String id;
        final int age;
        final String gender;

        Student(String name, String id, int age, String gender) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', id='" + id + "', age=" + age
                    + ", gender='" + gender + "'}";
        }
    }

    private static List<Student> readStudents(Path file) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
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
                if (fields.length != 4) {
                    System.out.println("Skipping invalid student row: " + line);
                    continue;
                }
                try {
                    students.add(new Student(fields[0].trim(), fields[1].trim(),
                            Integer.parseInt(fields[2].trim()), fields[3].trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping row with invalid age: " + line);
                }
            }
        }
        return students;
    }

    public static void main(String[] args) throws InterruptedException {
        int n;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            n = input.nextInt();
        }
        if (n < 0) {
            System.out.println("n must be zero or greater.");
            return;
        }

        Runnable sumTask = () -> {
            long sum = (long) n * (n + 1) / 2;
            System.out.println("Sum from 1 to " + n + " = " + sum);
        };

        Runnable primeTask = () -> {
            System.out.print("Primes from 1 to 100: ");
            for (int number = 2; number <= 100; number++) {
                boolean prime = true;
                for (int divisor = 2; divisor * divisor <= number; divisor++) {
                    if (number % divisor == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) System.out.print(number + " ");
            }
            System.out.println();
        };

        Runnable studentTask = () -> {
            try {
                List<Student> students = readStudents(STUDENT_CSV);
                System.out.println("Students loaded into ArrayList: " + students.size());
                students.forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("Could not read " + STUDENT_CSV
                        + ". Create it with columns name,ID,age,gender.");
            }
        };

        Thread sumThread = new Thread(sumTask, "sum");
        Thread primeThread = new Thread(primeTask, "primes");
        Thread studentThread = new Thread(studentTask, "students");
        sumThread.start();
        primeThread.start();
        studentThread.start();
        sumThread.join();
        primeThread.join();
        studentThread.join();
    }
}
