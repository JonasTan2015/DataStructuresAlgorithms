/**
 * Created by 310288079 on 8/8/2017.
 */
public class DecodeWays2 {

    public long solve(String encoded) {
        int mod = 1000000007;
        long[] dp = new long[encoded.length() + 1];

        if(encoded.charAt(0) == '0')
            return 0;

        dp[0] = 1;
        dp[1] = (encoded.charAt(0) == '*')? 9:1;

        for(int i = 2; i < dp.length; i ++){

            char curr = encoded.charAt(i - 1);
            char prev = encoded.charAt(i - 2);

            //curr char alone
            if(curr >= '1' && curr <= '9') dp[i] += dp[i - 1] * 1;
            else if(curr == '*') dp[i] += dp[i - 1] * 9;

            //2 chars together
            if(curr >= '0' && curr <= '9' && prev >= '1' && prev <= '2' && (prev - '0') * 10 + curr - '0' <= 26 && (prev - '0') * 10 + curr - '0' >= 10)
                dp[i] += dp[i - 2];

            else if(prev == '*' && curr >= '0' && curr <= '9'){
                if(curr <= '6')
                    dp[i] += dp[i - 2] * 2;
                else
                    dp[i] += dp[i - 2] * 1;
            }

            else if(prev == '1'&& curr == '*')
                dp[i] += dp[i - 2] * 9;

            else if(prev == '2' && curr == '*')
                dp[i] += dp[i - 2] * 6;

            else if(prev == '*' && curr == '*')
                dp[i] += dp[i - 2] * 15;

        }
        for(long num : dp)
            System.out.print(num + ", ");
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        DecodeWays2 dw2 = new DecodeWays2();
        dw2.solve("12*45");
    }
}
