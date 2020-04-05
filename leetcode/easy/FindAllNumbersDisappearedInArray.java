package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
