package leetcode.easy;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 1) {
            return n == 1;
        }
        while (n > 1) {
            if (n % 2 == 1) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}
