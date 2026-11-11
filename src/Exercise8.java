public class Exercise8 {
    public static class User {
        private long id;
        private String password;

        public User(long id, String password) {
            this.id = id;
            this.password = password;
        }

        public void Print() {
            message();
        }

        public void message() {
            System.out.println("Task in running...");
            System.out.println(id);
            System.out.println(password);
        }
    }

    public static void main(String[] args) {
        User user = new User(700099999, "sak123") {
            @Override
            public void Print() {
                System.out.println("Hello there!!");
            }
        };
    }
}
