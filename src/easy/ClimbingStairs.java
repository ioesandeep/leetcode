package easy;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return count(n, memo);
    }

    int count(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = count(n - 1, memo) + count(n - 2, memo);
        return memo[n];
    }
}
