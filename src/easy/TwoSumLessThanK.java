package easy;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int max = -1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum >= K) {
                j--;
            } else {
                max = Math.max(max, sum);
                i++;
            }
        }

        return max;
    }
}
