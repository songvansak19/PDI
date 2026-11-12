public class Exercise3 {
    public static class Person {
        String name;
        public Person(String name) {
            this.name = name;
        }
    }

    public static class Student extends Person{
        long id;
        public Student(String name, long id) {
            super(name);
            this.id = id;
        }
    }

    public static class OnlineStudent extends Student {
        long zoom_id;
        public OnlineStudent(String name, long id, long zoom_id) {
            super(name, id);
            this.zoom_id = zoom_id;
        }
    }

    public static void main(String[] args) {
        OnlineStudent onlineStudent = new OnlineStudent("Lor Hengleap", 0, 0);

        System.out.println("Online Student Info:");
        System.out.println("Name: " + onlineStudent.name);
        System.out.println("ID: " + onlineStudent.id);
        System.out.println("Zoom ID: " + onlineStudent.zoom_id);
    }
}
