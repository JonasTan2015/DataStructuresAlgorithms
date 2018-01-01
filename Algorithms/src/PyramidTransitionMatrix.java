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


    public boolean pyramidTransition(String bottom, List<String> allowed) {
        LinkedList<Set<Character>> curr = new LinkedList<>();
        for(int i = 0; i < bottom.length(); i ++){
            curr.add(new HashSet<Character>());
            curr.get(i).add(bottom.charAt(i));
        }

        HashMap<String, Set<Character>> memo = new HashMap<>();
        for(String allow : allowed){
            String key = allow.substring(0, 2);
            if(!memo.containsKey(key)) memo.put(key, new HashSet<Character>());
            memo.get(key).add(allow.charAt(2));
        }

        StringBuilder sb = new StringBuilder();
        while(curr.size() > 1){
            LinkedList<Set<Character>> next = new LinkedList<>();
            for(int i = 0; i < curr.size() - 1; i ++){
                HashSet<Character> set = new HashSet<Character>();

                for(char left : curr.get(i)){
                    for(char right : curr.get(i + 1)){
                        sb.append(left).append(right);
                        if(memo.containsKey(sb.toString())) set.addAll(memo.get(sb.toString()));
                        sb.setLength(0);
                    }
                }

                if(set.size() == 0)
                    return false;

                next.add(set);
            }

            curr = next;
        }

        return true;
    }

    public static void main(String[] args){
        PyramidTransitionMatrix p = new PyramidTransitionMatrix();
        boolean result = p.pyramidTransition("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ"));
        System.out.println(result);
    }
}
