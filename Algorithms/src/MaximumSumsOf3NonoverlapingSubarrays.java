public class MaximumSumsOf3NonoverlapingSubarrays {

    public static void main(String[] args){
        int[] array = new int[]{1,2,1,2,6,7,5,1};
        int k = 2;
        MaximumSumsOf3NonoverlapingSubarrays solve = new MaximumSumsOf3NonoverlapingSubarrays();
        solve.maxSumOfThreeSubarrays(array, k);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k){
        //思路：
        // 计算一次前缀和，sum[i] = sum of (num[i - k + 1] ... num[i])
        // 用数组ss[i] ss[i] = max(sum[0] ... sum[i - k]) + sum[i]  表示假如当前位置是第二段 则第一段可以从0 到 i - k取到的最大前缀和
        // 用数组sss[i] = max(ss[0]...ss[i - k]) + sum[i]

        //我们需要用数组记录每个max 数组的起始点

        //前缀和
        int len = nums.length;
        int[] prefixSum = new int[len];
        for(int i = 0; i < nums.length; i ++){
            prefixSum[i] = nums[i];
            prefixSum[i] += (i > 0)? prefixSum[i - 1] : 0;
        }

        // maxPrefixSum[i]  0~ i中，长度为k，最大前缀和
        int[] maxPrefixSum = new int[len];
        maxPrefixSum[0] = prefixSum[0];
        for(int i = 1; i < len; i ++){
            int currentPrefixSum = prefixSum[i] - (i - k >= 0? prefixSum[i - k] : 0);
            if(currentPrefixSum > maxPrefixSum[i - 1]){
                maxPrefixSum[i] = currentPrefixSum;
            }else{
                maxPrefixSum[i] = maxPrefixSum[i - 1];

            }
        }
        displayArray(prefixSum);
        displayArray(maxPrefixSum);

        //计算第二段的最大前缀和
        int[] secondMaxPrefixSum = new int[len];
        for(int i = 2*k - 1; i < len; i ++){
            int secondPrefixSum = prefixSum[i] - prefixSum[i - k] + maxPrefixSum[i - k];
            secondMaxPrefixSum[i] = Math.max(secondPrefixSum, secondMaxPrefixSum[i - 1]);
        }

        //计算第三段最大前缀和
        int[] thirdMaxPrefixSum = new int[len];
        for(int i = 3*k - 1; i < len; i ++){
            int thirdPrefixSum = prefixSum[i] - prefixSum[i - k] + secondMaxPrefixSum[i - k];
            thirdMaxPrefixSum[i] = Math.max(thirdPrefixSum, thirdMaxPrefixSum[i - 1]);
        }

        displayArray(secondMaxPrefixSum);
        displayArray(thirdMaxPrefixSum);


        // search for the indexes
        int[] result = new int[3];
        int index = len - 1;
        while(index > 0 && thirdMaxPrefixSum[index] == thirdMaxPrefixSum[index - 1]) index --;
        result[2] = index - k + 1;
        index = index - k;
        while(index > 0 && secondMaxPrefixSum[index] == secondMaxPrefixSum[index - 1]) index --;
        result[1] = index - k + 1;
        index = index - k;
        while(index > 0 && maxPrefixSum[index] == maxPrefixSum[index - 1]) index --;
        result[0] = index - k + 1;


        displayArray(result);
        return result;
    }



    private void displayArray(int[] array){
        for(int num : array){
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}
