/**
 * Created by 310288079 on 7/2/2017.
 */
//public class NonnegativeIntegersWithoutConsecutiveOnes {
//    public int findIntegers(int num) {
//        String binary = Integer.toBinaryString(num);
//        int len = binary.length();
//        if(len == 0)
//            return 0;
//
//
//        int[] dp0 = new int[len];
//        int[] dp1 = new int[len];
//        int[] bnum = new int[len];
//
//        dp0[0] = 1;
//        dp1[0] = 1;
//        bnum[0] = 2;
//
//
//
//
//        for(int i = 1; i < len; i++){
//            dp0[i] = dp0[i - 1] + dp1[i - 1];
//            dp1[i] = dp0[i - 1];
//            bnum[i] = dp0[i] + dp1[i];
//        }
//
//        int ans = dp0[len - 1] + dp1[len - 1];
//        System.out.println("all: " + ans);
//        for(int i = 0; i < len - 1 ; i++ ){
//            if(binary.charAt(i) == '1' && binary.charAt(i + 1) == '1')
//                break;
//            if(binary.charAt(i) == '0' && binary.charAt(i + 1) == '0') {
//                // length of i+ 1 to last char - 1
//                ans -= bnum[len - 1 - (i + 1) + 1];
//                System.out.println("minus" + bnum[len - 1 - (i + 1) ]);
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args){
//        NonnegativeIntegersWithoutConsecutiveOnes s = new NonnegativeIntegersWithoutConsecutiveOnes();
//        s.findIntegers(4);
//    }
//}
//100


/*
** Solution 2: Nonnegative without consecutive ones
 */
public class NonnegativeIntegersWithoutConsecutiveOnes {
    public int solve(int n) {
        String str = Integer.toBinaryString(n);

        /*
        ** f[k] indicates how many integers without consecutive ones from 0 to 2^(k) - 1
         */
        int[] f = new int[str.length() + 1];
        f[0] = 1;
        f[1] = 2;
        for(int i = 2; i <= str.length(); i ++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        for(int i = 0; i < f.length; i ++){
            System.out.print(f[i] + ",");
        }

        System.out.println(str);

        /*
        ** for example input 1010
        ** the first digit is 1, so the integers nonconsecutive from 000 ~ 111 can all be adopted
        ** the second digit is 0, there is no guarantee that 00 ~ 01 are all match. Leave it
        ** the third digit is 1, so 00 to 01 can be adopted.
         *
          * Last of all, do not forget to test whether the current number is a match. If it is, res ++
         */
        int ans = 0;
        for(int k = 0; k < str.length(); k ++){
            if(str.charAt(k) == '1'){
                int digit = str.length() - k - 1;
                ans += f[digit];
                System.out.println("add " + f[digit]);
                if(k >= 1 && str.charAt(k - 1) == '1')
                    break;
            }
        }

        boolean accepted = true;
        for(int i = 0; i < str.length() - 1; i ++){
            if(str.charAt(i) == '1' && str.charAt(i + 1) == '1') {
                accepted = false;
                break;
            }
        }

        if(accepted)
            ans ++;
        return ans;
    }

    public int test(int n){
        int ans = 0;
        for(int i = 0; i <= n; i ++){
            String tmp = Integer.toBinaryString(i);
            boolean hasConsecutiveOnes = false;
            for(int j = 0; j < tmp.length() - 1; j ++){
                if(tmp.charAt(j) == '1' && tmp.charAt(j + 1) == '1'){
                    hasConsecutiveOnes = true;
                    break;
                }
            }
            if(!hasConsecutiveOnes)
                ans ++;
        }
        return ans;
    }

    public static void main(String[] args){
        NonnegativeIntegersWithoutConsecutiveOnes solution = new NonnegativeIntegersWithoutConsecutiveOnes();
        int test = 1000;
        System.out.println(solution.solve(test));
        System.out.println(solution.test(test));
    }
}


//11000
//
//00000 ~ 01111