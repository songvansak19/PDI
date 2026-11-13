package Challenge;

public class Exercise2 {
    public static class Discount {
        public double apply(double amount) {
            System.out.println("+5% discount");
            return amount * 0.95;
        }
    }

    public static class SeasonalDiscount extends Discount {
        @Override 
        public double apply(double amount) {
            double discount = super.apply(amount);
            System.out.println("+10% discount");
            return discount - amount * 0.1;
        }
    }

    public static class SeasonalDiscountNoSuper extends Discount {
        @Override 
        public double apply(double amount) {
            System.out.println("+10% discount");
            return amount * 0.90;
        }
    }

    public static void main(String[] args) {
        double amount = 100;
        System.out.println("Total: " + amount);

        // With super
        Discount discount1 = new SeasonalDiscount();
        double afterDis1 = discount1.apply(100);
        System.out.println("After Discount: " + afterDis1);

        // without super
        Discount discount2 = new SeasonalDiscountNoSuper();
        double afterDis2 = discount2.apply(amount);
        System.out.println("After Discount: " + afterDis2);
    }
}
