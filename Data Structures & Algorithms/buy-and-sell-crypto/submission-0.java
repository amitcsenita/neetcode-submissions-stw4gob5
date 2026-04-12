class Solution {
    public int maxProfit(int[] prices) {
        int minPriceSoFar = prices[0];
        int maxProfit = 0;
        
        for (int j = 1; j < prices.length; j++) {
          maxProfit = Math.max(maxProfit, prices[j] - minPriceSoFar); 
          minPriceSoFar = Math.min(minPriceSoFar, prices[j]); 
        }

        return maxProfit;
    }
}
