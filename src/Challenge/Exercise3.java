package Challenge;

public class Exercise3 {
    public static interface Trackable {
        void track();        
    }

    public static abstract class DeliveryService {
        public abstract void calculate_eta();
    }

    public static class CourierService extends DeliveryService implements Trackable {
        public void track() {
            System.out.println("Courier Service: tracking...");
        }

        @Override 
        public void calculate_eta() {
            System.out.println("Calculating ETA for Courier Service...");
        }
    }

    public static class DroneDelivery extends DeliveryService implements Trackable {
        public void track() {
            System.out.println("Drone Delivery: tracking...");
        }

        @Override 
        public void calculate_eta() {
            System.out.println("Calculating ETA for Drone Delivery...");
        }
    }

    public static class CargoTruck extends DeliveryService implements Trackable {
        public void track() {
            System.out.println("Cargo Truck: tracking...");
        }

        @Override 
        public void calculate_eta() {
            System.out.println("Calculating ETA for Cargo Truck...");
        }
    }

    public static void main(String[] args) {
        CourierService courier = new CourierService();
        courier.calculate_eta();
        courier.track();

        DroneDelivery drone = new DroneDelivery();
        drone.calculate_eta();
        drone.track();

        CargoTruck cargo = new CargoTruck();
        cargo.calculate_eta();
        cargo.track();
    }
}
