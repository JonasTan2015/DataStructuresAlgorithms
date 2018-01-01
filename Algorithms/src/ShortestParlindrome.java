/**
 * Created by 310288079 on 7/9/2017.
 */
public class ShortestParlindrome {
    public static void main(String[] args){
        ShortestParlindrome solve = new ShortestParlindrome();
        solve.shortestPalindrome("abcd");
    }


    public String shortestPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();
        String combine = str + "#" + rev;
        int[] lps = getLPS(combine);
        // str從第一個字母開始形成的最長palindrome
        int parlin_len = lps[lps.length - 1];
        String prepend = str.substring(parlin_len);
        sb.setLength(0);
        sb.append(prepend).reverse().append(str);
        System.out.println(sb.toString());
        return sb.toString();
    }

    //給出一個字符串，找出每個位置最長的相同前後綴
    public int[] getLPS(String str){
        int[] lps = new int[str.length()];
        int left = 0;
        int right = 1;
        while(right < str.length()){
            if(str.charAt(left) == str.charAt(right)){
                lps[right] = left + 1;
                left ++;
                right ++;
            }else{
                //字符不同就回退上一個。看看有沒有更短的最長前綴跟現在match
                if(left != 0){
                    left = lps[left - 1];
                }else{
                    lps[right] = 0;
                    right ++;
                }
            }
        }
        return lps;
    }
}
