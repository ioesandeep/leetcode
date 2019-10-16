package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    Set<Integer> set;

    public boolean isHappy(int n) {
        set = new HashSet<>();
        return helper(n);
    }

    boolean helper(int n) {
        int sum = sumDigits(n);
        if (sum == 1) {
            return true;
        }
        if (set.add(sum) == false) {
            return false;
        }

        return helper(sum);
    }

    int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            sum += rem * rem;
        }
        return sum;
    }
}
