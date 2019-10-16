package leetcode.medium;

public class PowerXN {
    public double myPow(double x, int n) {
        if (n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE) {
            if (x == 1) {
                return 1;
            }
            if (x == -1) {
                return n % 2 == 0 ? 1 : -1;
            }
            return 0;
        }

        if (n < 0) {
            return 1 / helper(x, Math.abs(n));
        }

        return helper(x, n);
    }

    double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = myPow(x, n / 2);
        return res * res * (n % 2 == 0 ? 1 : x);
    }
}
