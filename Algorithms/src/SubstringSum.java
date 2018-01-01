public class SubstringSum {
    // given a string containing 0~9. For all the possible substrings, find the sum of all numbers
    // construncted from the substrings.
    // example: 135  possible numbers are 1 13 3 135 35 5, return the sum of all the numbers

    public long solution(String str){
        int mask = 0;
        long res = 0;
        for(int i = str.length() - 1; i >= 0; i --){
            mask = mask * 10 + 1;
            res += mask * (i + 1) * (str.charAt(i) - '0');
        }
        return res;
    }

    public static void main(String[] args){
        SubstringSum ss =  new SubstringSum();
        System.out.println(ss.solution("135"));

    }
}
