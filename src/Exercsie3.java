import java.util.Scanner;

public class Exercsie3 {

    public class Book {
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
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("1 - Add new book");

        System.out.print("Enter Book Name: ");
        String name = input.nextLine();
        System.out.print("Entr Auther Name: ");
        String author = input.nextLine();
        System.out.print("Enter Book PriceL: ");
        double price = input.nextDouble();
        System.out.println("Here is your book:");
    }
}
