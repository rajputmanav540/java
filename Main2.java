import java.util.Scanner;

class Bank {
    private int balance;
    private Object lock = new Object(); // Object for synchronization

    public Bank(int initialValue) {
        this.balance = initialValue;
    }

    public void withdraw(int amt) {
        synchronized (lock) {
            while (amt > balance) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting to withdraw " + amt);
                    lock.wait(); // Wait until sufficient balance is available
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            balance -= amt;
            System.out.println(Thread.currentThread().getName() + " withdrawing " + amt + " final amount=" + balance);

            // Notify any waiting threads that the balance has been updated
            lock.notifyAll();
        }
    }

    public void deposit(int amt) {
        synchronized (lock) {
            balance += amt;
            System.out.println(Thread.currentThread().getName() + " depositing " + amt + " final amount=" + balance);

            // Notify any waiting threads that the balance has been updated
            lock.notifyAll();
        }
    }

    public synchronized int getSharedValue() {
        return balance;
    }
}

class WithdrawThread implements Runnable {
    private Bank b1;
    private int amt;

    public WithdrawThread(Bank b1, int amt) {
        this.amt = amt;
        this.b1 = b1;
    }

    @Override
    public void run() {
        b1.withdraw(amt);
    }
}

class DepositThread implements Runnable {
    private Bank b1;
    private int amt;

    public DepositThread(Bank b1, int amt) {
        this.amt = amt;
        this.b1 = b1;
    }

    @Override
    public void run() {
        b1.deposit(amt);
    }
}

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the bank balance:");
        int initialValue = sc.nextInt();
        System.out.println("Enter the amount to withdraw or deposit:");
        int amt = sc.nextInt();

        Bank b1 = new Bank(initialValue);

        Thread withdraw = new Thread(new WithdrawThread(b1, amt), "Thread#1");
        Thread deposit = new Thread(new DepositThread(b1, amt), "Thread#2");

        withdraw.start();
        deposit.start();
        try {
            withdraw.join();
            deposit.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
