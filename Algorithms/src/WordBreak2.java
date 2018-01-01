import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 310288079 on 7/10/2017.
 */
public class WordBreak2 {

    List<String> res = new ArrayList<String>();
    boolean[][] isWord = null;
    HashSet<String> set = new HashSet<String>();
    boolean[] canReachEnd = null;

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return res;
        int len = s.length();


        for(String str : wordDict)
            set.add(str);
        isWord = new boolean[len][len];
        findWords(s);

        canReachEnd = new boolean[len + 1];
        wordBreak1(s);

        findCombination(s, 0, "");
        return res;
    }

    private void findCombination(String s, int start, String tmp){
        if(start >= s.length()){
            res.add(tmp.substring(1));
        }
        for(int i = start; i < s.length(); i ++){
            if(isWord[start][i] == true && canReachEnd[start] == true){
                String copy = new String(tmp);
                copy = copy + " " + s.substring(start, i + 1);
                findCombination(s, i + 1, copy);
            }
        }
    }

    private void findWords(String s){
        for(int i = 0; i < s.length(); i ++){
            for(int j = i; j < s.length(); j ++){

                if(set.contains(s.substring(i, j + 1)))
                    isWord[i][j] = true;
            }
        }
    }

    private void wordBreak1(String s){
        int len = s.length();
        canReachEnd[len] = true;
        for(int i = len - 1; i >= 0; i --){
            for(int j = i; j < len; j ++){
                if(isWord[i][j] == true && canReachEnd[j + 1] == true){
                    canReachEnd[i] = true;
                    break;
                }
            }
        }
    }


        public static void main(String[] args){
            WordBreak2 wb = new WordBreak2();
            String[] arr = new String[]{"cat", "cats", "sand", "and", "dog"};
            ArrayList<String> list = new ArrayList<String>();
            for(String str : arr)
                list.add(str);
            wb.wordBreak("catsanddog", list);
        }

}
