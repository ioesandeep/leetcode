package leetcode.medium;

public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        int rem = k % 10;

        if (k == 1) {
            return 1;
        }

        if (rem % 2 == 0 || rem == 5) {
            return -1;
        }

        long n = 0;
        int len = 0;
        do {
            n = (n * 10 + 1) % k;
            len++;
        } while (n != 0);

        return len;
    }
}
