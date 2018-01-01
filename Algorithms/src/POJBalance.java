/**
 * Created by 310288079 on 8/17/2017.
 * POJ 1837
 */
public class POJBalance {
    public static void main(String[] args){
        POJBalance p = new POJBalance();
        System.out.println(p.solve(new int[]{-2, 3}, new int[]{3,4,5,8}));
    }

    private int min = 0;
    private int max = 0;

    public int solve(int[] hooks, int[] grams) {
        int maxhook = Integer.MIN_VALUE;
        int minhook = Integer.MAX_VALUE;
        for(int hook : hooks){maxhook = Math.max(maxhook, hook); minhook = Math.min(minhook, hook);}

        int totalWeight = 0;
        for(int gram : grams){totalWeight += gram;}

        min = totalWeight * minhook;
        max = totalWeight * maxhook;
        System.out.println(min + "   " + max);
        int[][] dp = new int[grams.length + 1][15001];

        dp[0][0] = 1;
        for(int i=1;i<=grams.length;i++)
            for(int j=0;j<=15000;j++)
                if(dp[i-1][j] != 0)  //优化，当放入i-1个物品时状态j已经出现且被统计过方法数，则直接使用统计结果
                    //否则忽略当前状态j
                    for(int k=0;k<=hooks.length;k++) {
                        System.out.println(i + "   " + j + getOffset(grams[i - 1] * hooks[k]) + "  " + j);
                        dp[i][j + getOffset(grams[i - 1] * hooks[k])] += dp[i - 1][j]; //状态方程
                    }

        return dp[dp.length - 1][0];
    }

    private int getOffset(int arm){
        return arm - min;
    }
}
