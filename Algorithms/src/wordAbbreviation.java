import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 310288079 on 8/17/2017.
 * Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.

 Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
 If the abbreviation doesn't make the word shorter, then keep it as original.


 * Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 */
public class wordAbbreviation {
    public static void main(String[] args) {
        wordAbbreviation wa = new wordAbbreviation();
        String[] ans = wa.wordsAbbreviation(new String[]{"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"});
        for(String word : ans)
            System.out.print(word + ", ");
    }



    private String[] wordsAbbreviation(String[] dict) {

        int len = dict.length;
        String[] ans = new String[len];
        int[] prefix = new int[len];
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < len; i++) {
            prefix[i] = 1;
            ans[i] = getAbbr(dict[i], 1);
            if (!count.containsKey(ans[i])) {
                count.put(ans[i], 0);
            }
            count.put(ans[i], count.get(ans[i]) + 1);
        }

        while (true) {
            boolean unique = true;
            for (int i = 0; i < len; i++) {
                if (count.get(ans[i]) > 1) {
                    prefix[i]++;
                    ans[i] = getAbbr(dict[i], prefix[i]);
                    if (!count.containsKey(ans[i])) {
                        count.put(ans[i], 0);
                    }
                    count.put(ans[i], count.get(ans[i]) + 1);
                    unique = false;
                }
            }
            if (unique) {
                break;
            }
        }
        return ans;
    }

    private String getAbbr(String s, int p) {
        if (p >= s.length() - 2) {
            return s;
        }
        String ans;
        ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
        return ans;
    }


}
