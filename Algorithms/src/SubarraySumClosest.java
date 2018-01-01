/**
 * Created by 310288079 on 6/24/2017.
 */
import java.util.*;
public class SubarraySumClosest {
    public int[] subarraySumClosest(int[] nums) {
        // write your code here

        int len = nums.length;
        ArrayList<Node> prefix = new ArrayList<Node>();
        prefix.add(new Node(0, -1));
        int sum = 0;
        for(int i = 0; i < len; i ++){
            sum += nums[i];
            Node node = new Node(sum, i);
            prefix.add(node);
        }

        Collections.sort(prefix, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.sum != n2.sum)
                    return n1.sum - n2.sum;
                else
                    return n1.index - n2.index;
            }
        });

        System.out.println(prefix);

        int[] res = new int[2];
        int smallest_abs = Integer.MAX_VALUE;
        for(int i = 0; i < prefix.size() - 1; i++){
            int absolute = Math.abs(prefix.get(i).sum - prefix.get(i + 1).sum);
            if(absolute < smallest_abs){
                res[0] = Math.min(prefix.get(i).index , prefix.get(i+1).index) + 1;
                res[1] = Math.max(prefix.get(i).index , prefix.get(i+1).index);
                smallest_abs = absolute;
            }
        }
        System.out.println(res[0] + ", "+ res[1]);
        return res;

    }

    class Node{
        int sum = 0;
        int index = 0;
        private Node(int sum, int index){
            this.sum = sum;
            this.index = index;
        }

        public String toString(){
            return "("+Integer.toString(sum) +", " + Integer.toString(index) + ")";
        }
    }

    public static void main(String[] args){
        SubarraySumClosest s = new SubarraySumClosest();
        s.subarraySumClosest(new int[]{-10,-2,-3,-100,1,2,3,-1,4});
    }
}
