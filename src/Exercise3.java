import java.util.Scanner;

public class Exercise3 {

    public static class Book {
        String title;
        String author;
        double price;

        public Book() {
            title = "unknown";
            author = "unknown";
            price = 0.0;
        }

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public void display() {
            System.out.println("Book details: ");
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: " + price);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 - Add new book");
        System.out.println("2 - Add empty book");
        System.out.print("Your Option: ");
        int option = input.nextInt();
        switch (option) {
            case 1: {
                System.out.print("Enter Book Name: ");
                String name = input.nextLine();
                System.out.print("Enter Author Name: ");
                String author = input.nextLine();
                System.out.print("Enter Book Price: ");
                double price = input.nextDouble();
                System.out.println("Here is your book:");
                Book book = new Book(name, author, price);
                book.display();
                break;
            }
            case 2: {
                Book book = new Book();
                System.out.println("Here is your book:");
                book.display();
            }
            default:
                break;
        }
        input.close();
    }
}
