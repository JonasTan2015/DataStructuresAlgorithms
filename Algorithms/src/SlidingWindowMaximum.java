import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by 310288079 on 7/9/2017.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0)
            return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();

        // put first k elements into deque
        for(int i = 0 ; i < k ; i ++){
            insertDeque(deque, nums[i]);
        }
        for(Iterator itr = deque.iterator(); itr.hasNext();)  {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
        res[0] = deque.peekFirst();

        for(int i = k; i < nums.length; i ++){
            insertDeque(deque, nums[i]);
            pollDeque(deque, nums[i - k]);
            res[i - k + 1] = deque.peekFirst();

            for(Iterator itr = deque.iterator();itr.hasNext();)  {
                System.out.print(itr.next() + ", ");
            }
            System.out.println();
        }

        return res;
    }

    private void insertDeque(Deque<Integer> deque, int num){
        while(!deque.isEmpty() && deque.peekLast() <= num){
            deque.poll();
        }
        deque.offer(num);
    }

    private void pollDeque(Deque<Integer> deque, int num){
        if(deque.peekFirst() == num){
            deque.pollFirst();
        }
    }

    public static void main(String[] args){
        SlidingWindowMaximum slide = new SlidingWindowMaximum();
        slide.maxSlidingWindow(new int[]{7, 2, 4}, 2);
    }
}
