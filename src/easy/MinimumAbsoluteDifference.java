package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < minDiff) {
                minDiff = arr[i] - arr[i - 1];
            }
        }

        for (int i = 1; i < arr.length; i++) {
            List<Integer> gap = new ArrayList<>();
            if (arr[i] - arr[i - 1] == minDiff) {
                gap.add(arr[i - 1]);
                gap.add(arr[i]);
                result.add(gap);
            }
        }
        return result;
    }
}
