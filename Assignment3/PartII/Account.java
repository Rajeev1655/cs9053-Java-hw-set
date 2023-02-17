 
public class Account {
    private static int account_count;
    private double balance;
    private int id;

    public Account(){};

    public Account(double startingBalance) {
        this.balance = startingBalance;
        account_count++;
        this.id = account_count;
    }

    public boolean withdraw(double amount) {
        if (this.balance < amount) {
            return false;
        }else {
            this.balance -= amount;
            return true;
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getId() {
        return this.id;
    }
}
