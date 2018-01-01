import java.util.Stack;

public class VerifySequenceIsPreorderBST {
    public boolean solution(int[] array){
        Stack<Integer> stack = new Stack<Integer>();
        int root = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i ++){
            if(array[i] < root)
                return false;

            while(!stack.isEmpty() && array[i] > stack.peek()){
                root = stack.pop();
            }

            stack.push(array[i]);
        }

        return true;
    }


    public static void main(String[] args){
        VerifySequenceIsPreorderBST v = new VerifySequenceIsPreorderBST();
        System.out.println(v.solution(new int[]{2,4,3})); // true
        System.out.println(v.solution(new int[]{2, 4, 1})); // false
        System.out.println(v.solution(new int[]{40, 30, 35, 80, 100})); // true
        System.out.println(v.solution(new int[]{40, 30, 35, 20, 80, 100})); //false
    }
}




