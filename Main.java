import java.util.Scanner;

class Number {
    private int x;
    private int originalValue;

    public Number(int initialValue) {
        this.x = initialValue;
        this.originalValue = initialValue;
    }

    public synchronized void increment() {
        x++;
        System.out.println(Thread.currentThread().getName() + " incrementing " + x);
    }

    public synchronized void decrement() {
        x--;
        System.out.println(Thread.currentThread().getName() + " decrementing " + x);
    }

    public synchronized void reset() {
        x = originalValue;
    }

    public synchronized int getSharedValue() {
        return x;
    }
}

class Increment implements Runnable {
    private Number n1;
    private int n;

    public Increment(Number n1, int n) {
        this.n1 = n1;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            n1.increment();
        }
        // Reset the value of x to the original value after incrementing
        n1.reset();
    }
}

class Decrement implements Runnable {
    private Number n1;
    private int n;

    public Decrement(Number n1, int n) {
        this.n1 = n1;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            n1.decrement();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the initial value of x:");
        int initialValue = sc.nextInt();

        Number n1 = new Number(initialValue);

        System.out.println("Enter the number of times to increment and decrement:");
        int n = sc.nextInt();

        Thread increment = new Thread(new Increment(n1, n), "Thread for increasing");
        Thread decrement = new Thread(new Decrement(n1, n), "Thread for decreasing");

        increment.start();
        decrement.start();

        // Wait for both threads to finish
        try {
            increment.join();
            decrement.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
