package Challenge;

import java.util.ArrayList;
import java.util.List;

public class Exercise9 {
    public static class Person {
        private final String name;

        public Person(String name) {
            this.name = name;
        }

        public void work() {
            System.out.println(name + " is doing general work.");
        }

        public String getRole() {
            return "Person";
        }

        protected String getName() {
            return name;
        }
    }

    public static class Employee extends Person {
        public Employee(String name) {
            super(name);
        }

        @Override
        public void work() {
            System.out.println(getName() + " is completing employee work.");
        }

        @Override
        public String getRole() {
            return "Employee";
        }
    }

    public static abstract class Teacher extends Employee {
        public Teacher(String name) {
            super(name);
        }

        @Override
        public abstract void work();

        @Override
        public abstract String getRole();
    }

    public static class MathTeacher extends Teacher {
        public MathTeacher(String name) {
            super(name);
        }

        @Override
        public void work() {
            System.out.println(getName() + " is teaching mathematics.");
        }

        @Override
        public String getRole() {
            return "Math Teacher";
        }
    }

    public static class ScienceTeacher extends Teacher {
        public ScienceTeacher(String name) {
            super(name);
        }

        @Override
        public void work() {
            System.out.println(getName() + " is teaching science.");
        }

        @Override
        public String getRole() {
            return "Science Teacher";
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alex"));
        people.add(new Employee("Jordan"));
        people.add(new MathTeacher("Taylor"));
        people.add(new ScienceTeacher("Morgan"));

        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getRole());
            person.work();
        }
    }
}
