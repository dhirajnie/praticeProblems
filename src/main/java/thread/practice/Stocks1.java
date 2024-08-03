package thread.practice;

public class Stocks1 {

    public static int getMaxProfit(int nums[]) {
        int buyIndex = 0;
        int sellIndex = buyIndex + 1;
        int currentProfit=0;

        while (sellIndex < nums.length ) {
            if (nums[sellIndex] < nums[buyIndex]) {
                buyIndex = sellIndex;

            }
            if(nums[sellIndex]-nums[buyIndex]>currentProfit){
                currentProfit= nums[sellIndex]-nums[buyIndex];
            }

            ++sellIndex;

        }
        return currentProfit;

    }

    public static void main(String[] args) {
        int nums[] = {1,4,10,0,12};
        /*
           i=0,j=1 profit =0;
           i=1,j=2 profit =4;
           If j index is less than current buy index
           update buy index




         */
        System.out.println(getMaxProfit(nums));
    }
}
