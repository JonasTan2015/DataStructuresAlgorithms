import java.util.ArrayList;

/**
 * Created by 310288079 on 7/16/2017.
 */
public class BestTimeToBuyAndSellStock4 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock4 solution = new BestTimeToBuyAndSellStock4();
        int[] prices = new int[]{ 5,4,4, 3,3,2,1};
        solution.maxProfit(prices, 8);
    }

    /*
    *  Parmas:
    *      prices: Integer array. Stock prices at each time
    *      k: Integer. k transactions. A client could only buy and sell stocks for k times.
    *                  Also, client cannot hold more than 1 transactions at the same time.
     */

    public int maxProfit(int[] prices, int k) {
        int maxProfit = 0;
        if (prices == null || prices.length < 2)
            return 0;

        ArrayList<Pair> slopes = new ArrayList<Pair>();
        int peak = 0;
        int valley = 0;
        while (valley < prices.length - 1) {
            for (valley = peak; valley + 1 <= prices.length - 1 && prices[valley + 1] <= prices[valley]; valley++) ;

            for (peak = valley + 1; peak < prices.length && prices[peak] > prices[peak - 1]; peak++) ;

            if (prices[peak - 1] > prices[valley])
                slopes.add(new Pair(valley, peak - 1));

            valley = peak;
        }



        for(Pair p : slopes)
            System.out.print(p);
        return maxProfit;
    }


    private class Pair {
        int valley = 0;
        int peak = 0;

        Pair(int valley, int peak) {
            this.valley = valley;
            this.peak = peak;
        }

        public String toString() {
            return "( " + Integer.toString(valley) + ", " + Integer.toString(peak) + ")";
        }
    }
}
