import java.util.HashMap;

/**
 * Created by 310288079 on 7/8/2017.
 */
public class KMP {
    // This is the next array for KMP
    int[] next = null;
    public int[] next(char[] pattern){
        int len = pattern.length;
        next = new int[len];
        next[0] = -1;

        int k = -1;
        int j = 0;
        while(j < len - 1){
            if(k == -1 || pattern[k] == pattern[j]){
                k ++;
                j ++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }


    public int KMPSearch(String str, String pattern){
        int[] next = next(pattern.toCharArray());
        int i = 0;
        int j = 0;
        while(i < str.length() && j < pattern.length()){
            if(j == -1 || str.charAt(i) == pattern.charAt(j)){
                i ++;
                j ++;
            }else{
                j = next[j];
            }
        }

        if(j == pattern.length()){
            return i - j;
        }else{
            return -1;
        }
    }


    public static void main(String[] args){
        KMP k = new KMP();
        int res = k.KMPSearch("DABCEA", "ABC");
        System.out.println(res);
        res = k.KMPSearch("A", "A");
        System.out.println(res);
        int[] next = k.next("DABCDABDE".toCharArray());
        for(int num : next)
            System.out.print(num + ", ");
    }
}
