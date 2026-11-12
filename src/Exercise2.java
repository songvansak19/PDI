public class Exercise2 {
    public static class Employee {
        String name;
        double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double calculate_bonus() {
            return salary * 0.1;
        }
    }

    public static class Manager extends Employee {
        public Manager(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double calculate_bonus() {
            return salary * 0.2;
        }
    }

    public static class Intern extends Employee {
        public Intern(String name, double salary) {
            super(name, salary);
        }

        @Override 
        public double calculate_bonus() {
            return salary * 0.05;
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Bou Channa", 1000);
        Intern intern = new Intern("Lor Hengleap", 10);

        System.out.println("Manager salary: " +( manager.salary + manager.calculate_bonus()));
        System.out.println("Intern salary: " + (intern.salary + intern.calculate_bonus()));
    }
}
