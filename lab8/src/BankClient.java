public class BankClient extends Thread {
    private final int balanceChange;
    private final boolean isDeposit;
    private final BankAccount bankAccount;

    public BankClient(int balanceChange, BankAccount bankAccount) {
        this.isDeposit = balanceChange > 0;
        this.balanceChange = (isDeposit? balanceChange : -balanceChange);
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        synchronized (bankAccount) {
            System.out.println("Текущий баланс: " + bankAccount.balance() + " {Thread #" + getId() + "}");
            System.out.println("Операция " + (isDeposit ? "пополнения" : "снятия") + " на сумму " + balanceChange);
            if (!isDeposit) {
                boolean status = bankAccount.withdraw(balanceChange);
                if (!status) {
                    System.out.println("Недостаточно денег!" + " {Thread #" + getId() + "}");
                }
            } else {
                bankAccount.deposit(balanceChange);
            }
        }
    }
}
