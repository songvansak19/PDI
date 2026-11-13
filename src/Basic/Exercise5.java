package Basic;
import java.util.Arrays;
import java.util.List;

public class Exercise5 {
    public static class LibraryItem {
        protected String _title;
        protected long _id;

        public LibraryItem(String _title, int _id) {
            this._title = _title;
            this._id = _id;
        }

        public void display_info() {
            System.out.println("Book info: ");
            System.out.println("Title: " + _title);
            System.out.println("ID: " + _id);
        }
    }

    public static class Book extends LibraryItem {
        public Book(String _title, int _id) {
            super(_title, _id);
        }

        @Override
        public void display_info() {
            System.out.println("Book info: ");
            System.out.println("Title: " + _title.toUpperCase());
            List<String> string = Arrays.asList(String.valueOf(_id).split(""));

            System.out.print("ID: ");
            String.valueOf(_id).chars().forEach(c -> System.out.print((char) c + "-"));
            System.out.println();
            for (int i = 0; i < string.size(); i++) {
                System.out.print(string.get(i));
                if (i < string.size() - 1)
                    System.out.print("-");
            }
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Pacific Rim", 700099999);
        book.display_info();
    }
}
