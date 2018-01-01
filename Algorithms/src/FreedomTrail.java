/**
 * Created by 310288079 on 8/11/2017.
 * n the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.

 Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.

 Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at 12:00 direction and then by pressing the center button.
 At the stage of rotating the ring to spell the key character key[i]:
 You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to the character key[i].
 If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.
 */
public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length() + 1][ring.length()];
        int rowlen = dp.length;
        int collen = dp[0].length;

        dp[0][0] = 0;
        for(int i = 1; i < collen; i ++)
            dp[0][i] = Integer.MAX_VALUE;

        for(int row = 1; row < rowlen; row ++){
            for(int col = 0; col < collen; col ++){
                dp[row][col] = Integer.MAX_VALUE;
                if(key.charAt(row - 1) != ring.charAt(col))
                    continue;
                for(int precol = 0; precol < collen; precol++){
                    if(dp[row - 1][precol] != Integer.MAX_VALUE){
                        int left = Math.abs(col - precol);
                        int min = Math.min(collen - left, left);
                        dp[row][col] = Math.min(dp[row][col], min + dp[row - 1][precol]);
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int num : dp[rowlen - 1])
            res = Math.min(res, num);

        return res + key.length();
    }
}
