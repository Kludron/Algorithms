import java.util.Scanner;

public class Fibonacci {

    private double[] sequence;

    public Fibonacci(){;}

    public double calculate(int n) {
        if (n <= 0) {return 0;}
        if (n <= 2) {return 1;}

        this.sequence = new double[n];
        sequence[0] = 1;
        sequence[1] = 1;

        return fibonacci(n);
    }

    public double fibonacci(int n) {
        if (sequence[n-1] > 0) {
            return sequence[n-1];
        } else {
            sequence[n-1] = fibonacci(n-1) + fibonacci(n-2);
        }
        return sequence[n-1];
    }

    public double oldFibonacci(int n) {
        if (n <= 2) {
            return (double) 1;
        }
        return oldFibonacci(n-1) + oldFibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.calculate(Integer.parseInt(input.nextLine())));
        input.close();
    }

}