package microsoft.dynamic_programming;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
//121. Best Time to Buy and Sell Stock
class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int cheapestStock = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            maxProfit = Math.max(maxProfit, prices[i]-cheapestStock);
            cheapestStock = Math.min(cheapestStock, prices[i]);
            
            
        }
        
        return maxProfit;
    }
}