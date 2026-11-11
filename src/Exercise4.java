import java.util.Scanner;

public class Exercise4 {
    public static class Employee {
        private String name;
        private long id;
        private double salary;
        private int age;
        private String role;

        public Employee(
                String name,
                long id,
                double salary,
                int age,
                String role) {
            this.name = name;
            this.id = id;
            this.salary = salary;
            this.age = age;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public long getID() {
            return id;
        }

        public double getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        public String getRole() {
            return role;
        }

        public void deposit(double amount) {
            salary += amount;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter Age: ");
        int age = input.nextInt();
        System.out.print("Enter ID: ");
        long id = input.nextLong();
        System.out.print("Enter Salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter Role: ");
        input.nextLine();
        String role = input.nextLine();

        Employee employee = new Employee(name, id, salary, age, role);
        employee.getName();

        System.out.print("Enter amount to Deposit: ");
        double amount = input.nextDouble();
        employee.deposit(amount);

        System.out.println(employee.getSalary());
        input.close();
    }
}
