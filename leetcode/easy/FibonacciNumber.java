package leetcode.easy;

public class FibonacciNumber {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        int[] fib = new int[N + 2];
        fib[1] = 1;
        fib[2] = 1;
        return fib(N, fib);
    }

    private int fib(int n, int[] memo) {
        if (n < 1) {
            return 0;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = fib(n - 2) + fib(n - 1);
        return memo[n];
    }
}
