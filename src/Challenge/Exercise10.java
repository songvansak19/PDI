package Challenge;

public class Exercise10 {
    public interface TrackViewsMixin {
        int getViewCount();

        void setViewCount(int viewCount);

        default void trackView() {
            setViewCount(getViewCount() + 1);
            System.out.println("View tracked. Total views: " + getViewCount());
        }
    }

    public interface DiscountMixin {
        default double calculateDiscount(double price, double percentage) {
            return price * percentage / 100;
        }
    }

    public static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative");
            }
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class DigitalProduct extends Product
            implements TrackViewsMixin, DiscountMixin {
        private int viewCount;

        public DigitalProduct(String name, double price) {
            super(name, price);
        }

        @Override
        public int getViewCount() {
            return viewCount;
        }

        @Override
        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public double priceAfterDiscount(double percentage) {
            return getPrice() - calculateDiscount(getPrice(), percentage);
        }
    }

    public static void main(String[] args) {
        DigitalProduct product = new DigitalProduct("Java Course", 100.00);

        System.out.println(product.getName());
        System.out.printf("Original price: $%.2f%n", product.getPrice());
        System.out.printf("After 20%% discount: $%.2f%n",
                product.priceAfterDiscount(20));
        product.trackView();
        product.trackView();
    }
}
