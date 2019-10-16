package medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if ((a[0] >= b[0] && a[0] <= b[1]) || (b[0] >= a[0] && b[0] <= a[1])) {
                result.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
            }

            if (a[1] < b[1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
