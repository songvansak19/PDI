package Challenge;

public class Exercise1 {
    public static class InsurancePolicy {
        public void calculate_premium() {
            System.out.println("insurance Policy:");
            System.out.println("Calculate Premium:...");
        }
    }
    
    public static class HealthInsurance extends InsurancePolicy {
        @Override 
        public void calculate_premium() {
            System.out.println("Health Insurance:");
            System.out.println("Calculate Premium:...");
        }

    }
    
    public static class CarInsurance extends InsurancePolicy {
        @Override 
        public void calculate_premium() {
            System.out.println("Car Insurance:");
            System.out.println("Calculate Premium:...");
        }

        public void calculate_premium(int age_of_driver) {
            System.out.println("Car Insurance:");
            System.out.println("Driver Age: " + age_of_driver);
            System.out.println("Calculate Premium:...");
        }
    
        public void calculate_premium(int age, String accident_history) {
            System.out.println("Car Insurance:");
            System.out.println("Age: " + age);
            System.out.println("Accident History: " + accident_history);
            System.out.println("Calculate Premium:...");
        }
    }

        public static void main(String[] args) {
            // Overridden 
            System.out.println("Overridden:");
            InsurancePolicy carInsurance1 = new CarInsurance();
            InsurancePolicy healthInsurance = new HealthInsurance();
            carInsurance1.calculate_premium();
            healthInsurance.calculate_premium();
            System.out.println();

            // Overloading
            System.out.println("Overloading:");
            CarInsurance carInsurance2 = new CarInsurance();
            carInsurance2.calculate_premium();
            carInsurance2.calculate_premium(30);
            carInsurance2.calculate_premium(40, "Car crash accident");
        }
}
