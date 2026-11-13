package Basic;
public class Exercise7 {
    public static abstract class Payment {
        public abstract void process_payment(double amount);
    }

    public static class CreditCardPayment extends Payment {
        public void process_payment(double amount) {
            System.out.println("this is credit card payment method");
            System.out.println("Your amount: " + amount + "\n");
        }
    }

    public static class PayPalPayment extends Payment {
        public void process_payment(double amount) {
            System.out.println("this is paypal payment method");
            System.out.println("Your amount: " + amount + "\n");
        }
    }

    public static class BankTransferPayment extends Payment {
        public void process_payment(double amount) {
            System.out.println("this is bank transfer method");
            System.out.println("Your amount: " + amount + "\n");
        }
    }

    public static void main(String[] args) {
        new CreditCardPayment().process_payment(100);
        new PayPalPayment().process_payment(200);
        new BankTransferPayment().process_payment(300);
    }
}