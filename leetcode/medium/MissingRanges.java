package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            String range = getRange(lower, upper);
            result.add(range);
            return result;
        }
        //ll -> lower limit
        //ul - upper limit
        for (int i = 0; i <= nums.length; i++) {
            int ll = 0;
            int ul = 0;
            String range = "";
            if (i == nums.length) {
                //at i = nums.length
                //check the upper bound with the last element in the array
                ll = nums[i - 1];
                ul = upper;
                //if the last element is smaller than upper limit
                //get the missing range (last element + 1 to upper limit)
                if (ul > ll) {
                    range = getRange(ll + 1, ul);
                }
            } else if (i == 0) {
                //at i = 0
                //check the lower bound with first element in the array
                ll = lower;
                ul = nums[i] - 1;
                //the first element in greater than lower limit
                //get the missing range (lower limit to first element - 1)
                if (nums[i] > lower) {
                    range = getRange(ll, ul);
                }
            } else {
                //in normal cases
                //just compare the current value with previous value
                //if the gap is greater than 1
                //add the missing data from (previous value + 1 to current value - 1)
                ll = nums[i - 1];
                ul = nums[i];
                if (ul - ll == 1 || ul == Integer.MIN_VALUE || ll == Integer.MAX_VALUE) {
                    continue;
                }
                range = getRange(ll + 1, ul - 1);
            }
            //the missing range is not null
            //add it to result
            if (!range.equals("")) {
                result.add(range);
            }
        }
        return result;
    }

    String getRange(int lower, int upper) {
        if (lower > upper) {
            return "";
        }
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}
