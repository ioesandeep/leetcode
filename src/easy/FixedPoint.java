package easy;

public class FixedPoint {
    public int fixedPoint(int[] A) {
        return helper(A, 0, A.length);
    }

    int helper(int[] a, int from, int to) {
        if (from >= to) {
            return -1;
        }
        int mid = (from + to) / 2;
        if (mid == a[mid]) {
            int id = helper(a, from, mid);
            return id == -1 ? mid : id;
        }
        if (a[mid] > mid) {
            return helper(a, from, mid);
        }
        return helper(a, mid + 1, to);
    }
}
