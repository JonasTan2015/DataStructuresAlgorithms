import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * Created by 310288079 on 8/2/2017.
 */

/*
** Given an array of integers, return the number of arithmatic subsequences
**
 */
public class CountArithmaticSequences {

    public int solve(int[] nums){
        int len = nums.length;
        int[][] dp = new int[len][len];
        int count = 0;

        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j ++){
                dp[i][j] = 0;
                for(int k = 0; k < i; k ++){
                    dp[i][j] += (nums[i] - nums[k] == nums[j] - nums[i])?dp[k][i] + 1:0;
                }

                count += dp[i][j];
            }
        }

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j ++){
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }


        return count;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 2, 3, 4};
        CountArithmaticSequences cas = new CountArithmaticSequences();
        cas.solve(arr);
        cas.improvedSolution(arr);

    }

    /*
    *   Here is the solution. Given the last 2 points, instead of searching for the points before. We could make some improvement.
    *
    *   Each number is assigned a hash map. map(diff all the previous numbers, how many arithmetic ends with that number)
    *   Also, to avoid duplicate numbers such as 1, 2, 2, 3, 4. Inside the map value, we need to store how many times that same diff and same previous number shows up
    *
    *   1 :  null since there is no diff
    *   2 : 1: (0, 1)
    *   2:  0: (0, 1) 1:(0, 1)
    *   3:  1: (1, 1) -> 1: (2, 2) 2:(0, 1)
    *   4:  1: (4, 1) 2:(0, 1)-> 2:(0, 2) 3(0, 1)
    *
    *
    * */
    private int improvedSolution(int[] nums){
        List<HashMap<Integer, Pair>> maps = new ArrayList<HashMap<Integer, Pair>>();
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            HashMap<Integer, Pair> curr = new HashMap<Integer, Pair>();
            maps.add(curr);
            for(int j = 0; j < i; j ++){
                int diff = nums[i] - nums[j];

                if(!maps.get(j).containsKey(diff)){
                    if(!curr.containsKey(diff))
                        curr.put(diff, new Pair(0));
                    else
                        curr.get(diff).add(0);
                }else{
                    if(!curr.containsKey(diff)){
                        int sum = maps.get(j).get(diff).sum + maps.get(j).get(diff).count;
                        curr.put(diff, new Pair(sum));
                        count += sum;
                    }
                    else{
                        int sum = maps.get(j).get(diff).sum + maps.get(j).get(diff).count;
                        curr.get(diff).add(sum);
                        count += sum;
                    }

                }
            }

            System.out.println(curr);
        }

//        System.out.println(count);
        return count;
    }

    /*
    **
    **
    **/
    class Pair {

        int sum = 0;
        int count = 0;
        Pair(int sum){
            this.sum = sum;
            count = 1;
        }

        void add(int num){
            this.sum += num;
            count ++;
        }

        public String toString(){
            return "(" + Integer.toString(sum) + ", " + Integer.toString(count) + ")";
        }
    }
}
