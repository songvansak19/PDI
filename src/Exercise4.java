public class Exercise4 extends Thread {
    public static class Bank {
        protected long account_number;
        protected double balance;

        public Bank(long account_number, double balance) {
            this.account_number = account_number;
            this.balance = balance;
        }
    }

    public static class SavingsAccount extends Bank {
        private double interest_rate;

        public SavingsAccount(
                long account_number,
                double balance,
                double interest_rate) {
            super(account_number, balance);
            this.interest_rate = interest_rate;
        }

        public void display() {
            System.out.println("Account number: " + account_number);
            System.out.println("balance: " + balance);
            System.out.println("Interest rate: " + interest_rate);
        }
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(
                700099999,
                1000.0,
                0.10);

        savingsAccount.display();
    }
}
