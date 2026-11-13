package Challenge;

public class Exercise4 {
    public static class BankError extends Exception {
        public BankError(String error_message) {
            super(error_message);
        }

    }

    public static class InsufficientFundsError extends BankError {
        public InsufficientFundsError(String error_message) {
            super(error_message);
        }
    }

    public static class AccountNotFoundError extends BankError {
        public AccountNotFoundError(String error_message) {
            super(error_message);
        }
    }

    public static class CurrencyMismatchError extends BankError {
        public CurrencyMismatchError(String error_message) {
            super(error_message);
        }
    }

    public static class Account {
        private String name;
        private long accountNumber;
        private double balance;

        public Account(String name, long accountNumber, double balance) {
            this.name = name;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public String getName() {
            return name;
        }

        public long getAccountNumber() {
            return accountNumber;
        }
    }

    // this is called 'helper function'
    public static void transfer(
        double amount,
        Account account,
        String fromCurrency,
        String toCurrency
    ) throws BankError {
        if (account == null) {
            throw new AccountNotFoundError("Account not found!!");
        } else if (!fromCurrency.equals(toCurrency)) {
            throw new CurrencyMismatchError("Currency Mismatched!!");
        } else if (amount <= 0 || amount > account.getBalance()) {
            throw new InsufficientFundsError("Insufficient Balance!!");
        } else {
            System.out.println("Transfer Successful!!");
        }
    }

    public static void main(String[] args) {
        Account user = new Account("Song Vansak", 700099999, 1000);

        try {
            /*
            This basically means the sender (fromCurrency) and the receiver (toCurrency)
            must have the same currency type, and that is how most bank transfer money work 
            */
            transfer(100, user, "USD", "RIEL"); 
        } catch (BankError e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            transfer(0, user, "USD", "USD");
        } catch (BankError e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            transfer(2000, user, "USD", "USD");
        } catch (BankError e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            transfer(100, null, "USD", "USD");
        } catch (BankError e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            transfer(250, user, "USD", "USD");
        } catch (BankError e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
