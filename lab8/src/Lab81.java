import java.util.concurrent.Callable;

/*
    Реализовать многопоточное приложение “Банк”. Имеется банковский счет. Сделать
    синхронным пополнение и снятие денежных средств на счет/со счет случайной суммой.
    При каждой операции (пополнения или снятие) вывести текущий баланс счета. В том
    случае, если денежных средств недостаточно – вывести сообщение.
*/

public class Lab81 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Thread client1 = new BankClient(-1500, account);
        Thread client2 = new BankClient(100, account);
        Thread client3 = new BankClient(1500, account);
        Thread client4 = new BankClient(-800, account);

        client1.start();
        client2.start();
        client3.start();
        client4.start();
    }
}