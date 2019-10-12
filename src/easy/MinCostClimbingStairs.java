package easy;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        return minCost(cost, -1, memo);
    }

    int minCost(int[] cost, int pos, int[] memo) {
        if (pos >= cost.length) {
            return 0;
        }
        if (memo[pos + 1] > 0) {
            return memo[pos + 1];
        }

        int val = pos < 0 ? 0 : cost[pos];
        int first = minCost(cost, pos + 1, memo);
        int second = minCost(cost, pos + 2, memo);
        memo[pos + 1] = val + Math.min(first, second);
        return memo[pos + 1];
    }
}
