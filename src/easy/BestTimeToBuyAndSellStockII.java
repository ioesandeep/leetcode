package easy;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int diff = prices[i] - min;
            max = max < diff ? diff : max;
            min = min < prices[i] ? min : prices[i];
        }
        return max;
    }
}
