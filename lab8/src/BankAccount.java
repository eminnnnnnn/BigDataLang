public class BankAccount {
    private int balance;

    public BankAccount(int initBalance) {
        this.balance = initBalance;
    }

    public boolean withdraw(int amount) {
        boolean status = (amount > 0) && (this.balance - amount >= 0);
        this.balance = (status ? this.balance - amount : this.balance);
        return status;
    }

    public boolean deposit(int amount) {
        this.balance += amount;
        return true;
    }

    public int balance() { return this.balance; }
}
