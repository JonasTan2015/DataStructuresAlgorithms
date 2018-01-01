import java.util.HashMap;

/**
 * Created by 310288079 on 7/6/2017.
 */

//leetcode 128
public class LongestConsecutiveSequence {
}


class UnionFind {
    int[] arr = null;
    HashMap<Integer, Integer> map = null;

    public UnionFind (int[] arr){
        this.arr = new int[arr.length];
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i ++){
            this.arr[i] = i;
            map.put(arr[i], i);
        }
    }


}