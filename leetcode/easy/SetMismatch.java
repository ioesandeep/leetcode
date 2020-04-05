package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int expected = (nums.length * (nums.length + 1)) / 2;
        int real = 0;
        int dup = 0;
        for (int num : nums) {
            real += num;
            if (!set.add(num)) {
                dup = num;
            }
        }

        int[] res = new int[2];
        res[0] = dup;
        res[1] = dup + expected - real;

        return res;
    }
}
