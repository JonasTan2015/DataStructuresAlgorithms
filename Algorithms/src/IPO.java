/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

 You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

 To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.

 Example 1:
 Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

 Output: 4

 Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 After finishing it you will obtain profit 1 and your capital becomes 1.
 With capital 1, you can either start the project indexed 1 or the project indexed 2.
 Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 */
import java.util.PriorityQueue;


public class IPO {

    class Pair{
        int capital = 0;
        int profit = 0;
        Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int solve(int k, int W, int[] Profits, int[] Capital){
        if(k <= 0 || Profits == null || Profits.length == 0 || Capital == null || Capital.length == 0)
            return 0;

        int count = 0;
        int currentCapital = W;
        int totalProfit = 0;

        PriorityQueue<Pair> canBuy = new PriorityQueue<Pair>(k, (p1, p2)->{return p2.profit - p1.profit;});

        PriorityQueue<Pair> choiceList = new PriorityQueue<Pair>(k, (p1, p2)->{return p1.capital - p2.capital;});


        for(int i = 0; i < Profits.length; i ++){
            if(W >= Capital[i])
                canBuy.offer(new Pair(Capital[i], Profits[i]));
            else
                choiceList.add(new Pair(Capital[i], Profits[i]));
        }

        while(count < k && choiceList.size() > 0 && canBuy.size() > 0){
            Pair deal = canBuy.poll();
            totalProfit += deal.profit;
            currentCapital += deal.profit;
            count ++;
            while(choiceList.size() > 0 && choiceList.peek().capital <= currentCapital){
                canBuy.offer(choiceList.poll());
            }
        }

        return totalProfit;
    }
}
