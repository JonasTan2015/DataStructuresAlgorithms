import java.util.*;

/**
 * Created by asus on 12/31/2017.
 * 756. Pyramid Transition Matrix My SubmissionsBack to Contest
 Virtual User Accepted: 0
 Virtual User Tried: 0
 Virtual Total Accepted: 0
 Virtual Total Submissions: 0
 Difficulty: Medium
 We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

 For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

 We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

 Return true if we can build the pyramid all the way to the top, otherwise false.


 Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 Output: true
 Explanation:
 We can stack the pyramid like this:
 A
 / \
 D   E
 / \ / \
 X   Y   Z

 This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
 */
public class PyramidTransitionMatrix {


    public boolean solution(String bottom, List<String> allowed){
        HashMap<String, List<String>> dp = new HashMap<String, List<String>>();
        for(String allow : allowed){
            dp.computeIfAbsent(allow.substring(0, 2), k -> new LinkedList<String>()).add(allow.substring(2));
        }

        return dfs(dp, bottom).size() > 0;
    }

    private List<String> dfs(HashMap<String, List<String>> dp, String lastLevel){
        if(dp.containsKey(lastLevel))
            return dp.get(lastLevel);

        List<String> list = new LinkedList<>();

        for(int i = 1; i < lastLevel.length() - 1; i ++){
            List<String> leftPossibilities = dfs(dp, lastLevel.substring(0, i + 1));
            List<String> rightPossibilities = dfs(dp, lastLevel.substring(i));
            if(leftPossibilities.size() == 0 || rightPossibilities.size() == 0) continue;

            for(String left: leftPossibilities){
                for(String right: rightPossibilities){
                    if(dfs(dp, left + right).size() > 0){
                        list.add(left + right);
                        break;
                    }
                }
            }
            break;
        }
        dp.put(lastLevel, list);

        return list;
    }

    public static void main(String[] args){
        PyramidTransitionMatrix p = new PyramidTransitionMatrix();
        boolean result = p.solution("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ"));
        System.out.println(result);
    }
}
