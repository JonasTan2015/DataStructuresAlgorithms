/**
 * Created by 310288079 on 8/15/2017.
 * Given an array, find a subarray with length >= k whose mean is greatest
 *
 * Solution: binary search
 * the smallest mean = smallest number in array
 * the greatest mean = greatest number in array
 *
 *each time, mid = (lowerbound + upperbound)/2, check if this mid can be achieved
 * To check whether it could be achieved. Suppose we would like to test mid
 * each element minus mid
 * for the current element index j, if current prefix sum - the smallest prefix sum in subarray [0, j - k] > 0
 * mid is possble
 *
 */
public class MaximumAverageSubarrayII {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        MaximumAverageSubarrayII solution = new MaximumAverageSubarrayII();
        System.out.println(solution.solve(array, 3));
    }

    public double solve(int[] array, int k) {
        double max = (double)Integer.MIN_VALUE;
        double min = (double)Integer.MAX_VALUE;
        for(int num : array){min = Math.min(min, (double)num); max = Math.max(max, (double)num);}

        double mid = 0;
        while(max - min > 0.001){
            mid = min + (max - min) / 2;
            if(check(array, k, mid)){
                min = mid;
            }else{
                max = mid;
            }
        }

        return mid;
    }

    private boolean check(int[] array, int k, double mid){
        int i = 0;
        double sum = 0;
        for(i = 0; i < k && i < array.length; i ++)
            sum += array[i] - mid;
        double premin = Integer.MAX_VALUE;
        double presum = 0;
        for(; i < array.length; i ++){
            presum += array[i - k] - mid;
            premin = Math.min(presum, premin);
            sum += array[i] - mid;
            if(sum - premin >= 0)
                return true;
        }
        return false;
    }
}
