package leetcode.easy;

public class ValidBoomerang {
    double distance(int[] p1, int[] p2) {
        int x = Math.abs(p1[0] - p2[0]);
        int y = Math.abs(p1[1] - p2[1]);
        return Math.sqrt(x * x + y * y);
    }

    public boolean isBoomerang(int[][] p) {
        if (p.length != 3) {
            return false;
        }

        double d1 = distance(p[0], p[1]);
        double d2 = distance(p[0], p[2]);
        double d3 = distance(p[1], p[2]);

        if (d1 == 0 || d2 == 0 || d3 == 0) {
            return false;
        }

        double semi = (d1 + d2 + d3) / 2;

        return Math.sqrt(semi * (semi - d1) * (semi - d2) * (semi - d3)) > 0;
    }
}
