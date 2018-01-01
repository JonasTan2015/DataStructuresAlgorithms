/*
 * Given a string. Find 2 longest palindrome sequence. Return the products of the 2 sequences
 */

import java.util.HashMap;

public class ProductOf2LongestPalindromSequencese {

    public void findPalindromeSequences(String str){
        // this record the longest palindrome length between index i and j
        int[][] dp = new int[str.length()][str.length()];

        boolean[][] visited = new boolean[str.length()][str.length()];

        for(int i = 0; i < str.length(); i ++){
            visited[i][i] = true;
            dp[i][i] = 1;
        }

        solve(str, dp, visited, 0, str.length() - 1);

        int product = 0;
        for(int i = 1; i < str.length(); i ++){
            product = Math.max(product, dp[0][i - 1] * dp[i][str.length() - 1]);
        }

        System.out.println(product);
    }

    private int solve(String str, int[][] dp, boolean[][] visited, int left, int right){
        if(left > right)
            return 0;
        if(visited[left][right])
            return dp[left][right];

        int a = solve(str, dp, visited, left, right - 1);
        int b = solve(str, dp, visited, left + 1, right);
        int c = solve(str, dp, visited, left + 1, right  - 1);

        if(str.charAt(left) == str.charAt(right))
            c += 2;
        dp[left][right] = Math.max(a, Math.max(b, c));
        visited[left][right] = true;
        return dp[left][right];
    }



    public static void main(String[] args){
        ProductOf2LongestPalindromSequencese p = new ProductOf2LongestPalindromSequencese();
        p.findPalindromeSequences("ababa");
    }
}
