package Challenge;

import java.util.ArrayList;
import java.util.List;

public class Exercise8 {
    public static abstract class RentalItem {
        private final String name;
        private final int days;

        protected RentalItem(String name, int days) {
            if (days < 1) {
                throw new IllegalArgumentException("Rental days must be positive");
            }
            this.name = name;
            this.days = days;
        }

        public String getName() {
            return name;
        }

        public int getDays() {
            return days;
        }

        public abstract double calculateCost();
    }

    public static class CarRental extends RentalItem {
        public CarRental(String name, int days) {
            super(name, days);
        }

        @Override
        public double calculateCost() {
            return getDays() * 50.0;
        }
    }

    public static class BikeRental extends RentalItem {
        public BikeRental(String name, int days) {
            super(name, days);
        }

        @Override
        public double calculateCost() {
            return getDays() * 15.0;
        }
    }

    public static class ToolRental extends RentalItem {
        public ToolRental(String name, int days) {
            super(name, days);
        }

        @Override
        public double calculateCost() {
            return getDays() * 25.0;
        }
    }

    public static class CameraRental extends RentalItem {
        public CameraRental(String name, int days) {
            super(name, days);
        }

        @Override
        public double calculateCost() {
            return getDays() * 40.0;
        }
    }

    public static void main(String[] args) {
        List<RentalItem> rentals = new ArrayList<>();
        rentals.add(new CarRental("Sedan", 3));
        rentals.add(new BikeRental("Mountain Bike", 2));
        rentals.add(new ToolRental("Power Drill", 4));
        rentals.add(new CameraRental("DSLR Camera", 1));

        double total = 0;
        for (RentalItem rental : rentals) {
            double cost = rental.calculateCost();
            total += cost;
            System.out.printf("%s (%d days): $%.2f%n",
                    rental.getName(), rental.getDays(), cost);
        }
        System.out.printf("Total rental cost: $%.2f%n", total);
    }
}
