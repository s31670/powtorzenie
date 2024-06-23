import java.util.ArrayList;
import java.util.List;

class BankAccount implements AccountOperations {
    private double balance;
    private List<Transaction> transactions;

    public BankAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public double checkBalance() {
        return this.balance;
    }

    public void transfer(BankAccount toAccount, double amount) throws AccountOperationException {
        if (amount <= 0 || amount > this.balance) {
            throw new AccountOperationException("Invalid transfer amount.");
        }
        this.balance -= amount;
        toAccount.deposit(amount);
        Transaction transaction = new Transaction(this, toAccount, amount);
        this.transactions.add(transaction);
        toAccount.addTransaction(transaction);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            Transaction transaction = new Transaction(null, this, amount);
            this.transactions.add(transaction);
        }
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

