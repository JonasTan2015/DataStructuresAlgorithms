import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by asus on 1/20/2018.
 */
public class ReorganizeString {
    public static void main(String[] args){
        ReorganizeString rs = new ReorganizeString();
        String res = rs.solve("aab");
        System.out.println(res);

    }
    public String solve(String str){
        Map<Character, Integer> ocurrance = new HashMap<>();
        for(char c : str.toCharArray()){
            ocurrance.put(c, ocurrance.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entrylist = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : ocurrance.entrySet()){
            entrylist.add(entry);
        }

        Collections.sort(entrylist, (a, b)->{return b.getValue() - a.getValue();});

        List<StringBuilder> stringlist = new ArrayList<>();
        for(int i = 0; i < entrylist.get(0).getValue(); i ++){
            StringBuilder sb = new StringBuilder();
            sb.append(entrylist.get(0).getKey());
            stringlist.add(sb);
        }

        int index = 0;
        for(int i = 1; i < entrylist.size();i ++){
            char c = entrylist.get(i).getKey();
            for(int j = 0; j < entrylist.get(i).getValue(); j ++){
                stringlist.get(index++).append(c);
                if(index >= stringlist.size()) index = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder sub : stringlist){
            sb.append(sub);
        }

        String result = sb.toString();
        for(int i = 1; i < result.length(); i ++)
            if(result.charAt(i) == result.charAt(i - 1))
                return "";
        return result;
    }


}
