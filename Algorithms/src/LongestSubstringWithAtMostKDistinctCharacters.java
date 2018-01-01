/**
 * Created by 310288079 on 7/7/2017.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int solve(String str, int k){
        // assume the string contains only 26 letters
        if( k <= 1)
            return k;
        int[] map = new int[26];

        int longest = 0;
        int left = 0;
        int right =  0;

        int distinct = 0;
        int ch = 0;
        while(right < str.length()){
            ch = str.charAt(right) - 'a';
            map[ch] ++;
            // if new character
            if(map[ch] == 1){
                distinct ++;
            }

            while(distinct > k){
                int leftchar = str.charAt(left) - 'a';
                map[leftchar] --;
                if(map[leftchar] == 0)
                    distinct --;
                left ++;
            }

            longest = Math.max(longest, right - left + 1);
            System.out.println("(" + left + ", "+ right + ")");
            right ++;
        }
        return longest;
    }

    public static void main(String[] args){
        LongestSubstringWithAtMostKDistinctCharacters l = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(l.solve("ecebaaaa", 2));
    }
}
