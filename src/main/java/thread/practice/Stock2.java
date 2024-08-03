package thread.practice;

public class Stock2 {

    static public int maxProfit(int[] prices) {
        int i = 0;
        int j = i + 1;
        int currentProfit = 0;
        boolean stockBought = false;
        while (j < prices.length) {
            if (!stockBought &&prices[i] > prices[j]) {
                // No Action
                ++j;
                ++i;
            } else if (prices[i] < prices[j] && !stockBought) {
                // buy new stock
                stockBought = true;

            } else if (stockBought && ((j + 1 < prices.length  && prices[j] >prices[j + 1]) || j == prices.length - 1)) {
                // sell
                currentProfit += prices[j] - prices[i];
                i=j+1;
                j=j+2;
                stockBought=false;
            } else if(stockBought) {
                // Price increasing
                ++j;
            }
            else{
                ++i;
                ++j;
            }
        }
        if(stockBought && prices[i]<prices[prices.length-1]){
            currentProfit+=prices[prices.length-1]-prices[i];
        }

        return currentProfit;
    }

    public static void main(String[] args) {
        int nums[] = {8,6,4,3,3,2,3,5,8,3,8,2,6};
        System.out.println(maxProfit(nums));
    }
}
