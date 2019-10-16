package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int num1 = nums[i];
            if (!set.add(num1)) {
                return true;
            }
        }
        return false;
    }
}
