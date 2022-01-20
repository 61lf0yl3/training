class BestTimetoBuyandSellStock {
    // 121. Best Time to Buy and Sell Stock

    // Approach 1: One Pass
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            if (curr < min) {
                min = curr;
                max = curr;
            }
            if (max < curr) {
                max = curr;
            }
            res = Math.max(res, max - min);
        }
        return res;
    }

    // Approach 1: Kadane's Algorithm
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxProfit1(int[] prices) {
        int max = 0;
        int cheapest = Integer.MAX_VALUE;
        for (int price : prices) {
            cheapest = Math.min(cheapest, price);
            max = Math.max(max, price - cheapest);
        }
        return max;
    }

    // Approach 1: One Pass (leetcode version)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxProfit3(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    // Approach 2: Brute Force
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxProfit2(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
