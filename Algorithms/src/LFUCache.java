import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by 310288079 on 7/12/2017.
 */
public class LFUCache {

    HashMap<Integer, Integer> key_val = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> key_freq = new HashMap<Integer, Integer>();
    HashMap<Integer, LinkedHashSet<Integer>> freq_key = new HashMap<Integer, LinkedHashSet<Integer>>();
    int min = 0;
    int capacity = 0;


    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(key_val.get(key) == null)
            return -1;

        int freq = key_freq.get(key);
        freq_key.get(freq).remove(key);
        if(freq_key.get(freq).size() == 0){
            freq_key.remove(freq);
            if(min == freq){
                min ++;
            }
        }
        freq = freq + 1;
        if(!freq_key.containsKey(freq)){
            freq_key.put(freq, new LinkedHashSet<Integer>());
        }
        freq_key.get(freq).add(key);

        key_freq.put(key, freq);

        return key_val.get(key);
    }

    public void put(int key, int value) {
        if(capacity <= 0)
            return;
        if(key_val.containsKey(key)){
            key_val.put(key, value);
            get(key);
            return;
        }

        int curr_size = key_val.size();

        // pop one if necessary
        if(curr_size == capacity){
            int evit = freq_key.get(min).iterator().next();
            freq_key.get(min).remove(evit);
            key_freq.remove(evit);
            key_val.remove(evit);
            if(freq_key.get(min).size() == 0)
                freq_key.remove(min);
        }

        //insert one
        int freq = 0;
        if(!freq_key.containsKey(freq)){
            freq_key.put(freq, new LinkedHashSet<Integer>());
        }
        freq_key.get(freq).add(key);
        key_freq.put(key, 0);
        key_val.put(key, value);

        min = 0;
    }





}





