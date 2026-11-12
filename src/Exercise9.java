import java.util.ArrayList;
import java.util.List;

public class Exercise9 {
    public static abstract class Transport {
        protected double distance;

        public Transport(double distance) {
            this.distance = distance;
        }

        public abstract double calculate_fare();
        public void display_fare() {}; 
    }

    public static class BusTransport extends Transport {
        public BusTransport(double distance) {
            super(distance);
        }

        @Override
        public double calculate_fare() {
            return distance * 1.5;
        }

        @Override
        public void display_fare() {
            System.out.println("+ Transport Mode: Bus");
            System.out.println(" - Distance: " + distance);
            System.out.println(" - Fare Calculation: " + calculate_fare() + "\n");
        }
    }

    public static class MetroTransport extends Transport {
        public MetroTransport(double distance) {
            super(distance);
        }

        @Override
        public double calculate_fare() {
            return 10 + distance * 2;
        }

        @Override
        public void display_fare() {
            System.out.println("+ Transport Mode: Metro");
            System.out.println(" - Distance: " + distance);
            System.out.println(" - Fare Calculation: " + calculate_fare() + "\n");
        }
    }

    public static class TaxiTransport extends Transport {
        public TaxiTransport(double distance) {
            super(distance);
        }

        @Override
        public double calculate_fare() {
            return 20 + distance * 5;
        }

        @Override
        public void display_fare() {
            System.out.println("+ Transport Mode: Taxi");
            System.out.println(" - Distance: " + distance);
            System.out.println(" - Fare Calculation: " + calculate_fare() + "\n");
        }
    }

    public static void main(String[] args) {
        List<Transport> transports = new ArrayList<>();

        transports.add(new BusTransport(1000));
        transports.add(new MetroTransport(2000));
        transports.add(new TaxiTransport(3000));

        System.out.println("Transportation:\n");
        for (Transport transport : transports) {
            transport.display_fare();
        }
    }
}
