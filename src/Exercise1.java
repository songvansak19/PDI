public class Exercise1 {
    public static class Vehicle {
        protected String brand;
        protected int year;
        public void start() {
            System.out.println(brand + ": Start the engine: vroom vroom!!");
        }
    }

    public static class Car extends Vehicle {
        int num_door = 0;
        public Car(int num_door, String brand, int year) {
            this.brand = brand;
            this.year = year;
            this.num_door = num_door;
            super.start();
        }
        public void honk() {
            System.out.println("Car hoking: beep, beep!!");
        }
    }

    public static void main(String[] args) {
        Car car = new Car(4, "Toyota", 2026);

        car.honk();
    }    
}
