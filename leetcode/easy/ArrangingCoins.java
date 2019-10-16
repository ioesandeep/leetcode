package leetcode.easy;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        return coinsHelper(n, 1, 0);
    }

    int coinsHelper(int available, int target, int stairs) {
        if (target > available) {
            return stairs;
        }
        return coinsHelper(available - target, target + 1, stairs + 1);
    }
}
