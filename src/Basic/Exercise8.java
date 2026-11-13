package Basic;
import java.util.ArrayList;
import java.util.List;

public class Exercise8 {
    public static abstract class Product {
        protected String name;
        protected double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public abstract void get_info();
    }

    public static class Electronics extends Product {
        private int warranty;
        public Electronics(String name, double price, int warranty) {
            super(name, price);
            this.warranty = warranty;
        }

        @Override
        public void get_info() {
            System.out.println("+ Electronic device:");
            System.out.println("Electronic Name: " + name);
            System.out.println("Warranty: " + warranty);
            System.out.println("Price: " + price + "\n");
        }
    }

    public static class Clothing extends Product {
        private char size;
        public Clothing(String name, double price, char size) {
            super(name, price);
            this.size = size;
        }

        @Override
        public void get_info() {
            System.out.println("+ Clothing:");
            System.out.println("Brand Name: " + name);
            System.out.println("Size: " + size);
            System.out.println("Price: " + price + "\n");
        }
    }

    public static class Book extends Product {
        private String author;
        public Book(String name, double price, String author) {
            super(name, price);
            this.author = author;
        }

        @Override
        public void get_info() {
            System.out.println("+ Book:");
            System.out.println("Book Name: " + name);
            System.out.println("Author Name: " + author);
            System.out.println("Price: " + price + "\n");
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics("Fridge", 1200, 10));
        products.add(new Clothing("Ten Eleven", 16, 'M'));
        products.add(new Book("Demon Slayer", 20, "Gotōge Koyoharu"));

        System.out.println("Products list:\n");
        for (Product product : products) {
            product.get_info();
        }
    }
}
