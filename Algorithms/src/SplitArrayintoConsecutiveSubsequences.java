/**
 * Created by 310288079 on 8/14/2017.
 * For every element i, find a shortest arithmetic subsequence that ends with i - 1, insert this element into that sebsequence
 */

import java.util.*;

public class SplitArrayintoConsecutiveSubsequences {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,4,5};
        SplitArrayintoConsecutiveSubsequences cscs = new SplitArrayintoConsecutiveSubsequences();
        System.out.println(cscs.solve(array));
    }


    public boolean solve(int[] array) {
        if(array == null || array.length == 0) return false;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();



        for(int i = 0; i < array.length; i ++){
            if(!map.containsKey(array[i] - 1)){
                PriorityQueue<Integer> queue = map.getOrDefault(array[i], new PriorityQueue<Integer>());
                queue.offer(1);
                map.put(array[i], queue);
            }else{
                int len = map.get(array[i] - 1).poll();
                map.getOrDefault(array[i], new PriorityQueue<Integer>()).offer(len + 1);
                if(map.get(array[i] - 1).size() == 0)
                    map.remove(array[i] - 1);
            }
        }

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int val = 0;
            if((val = entry.getValue().poll()) < 3){
                System.out.println(entry.getKey() + ": " + val);
                return false;
            }
        }
        return true;
    }



}
