/**
 * Created by asus on 12/26/2017.
 * 553. Optimal Division My SubmissionsBack to Contest
 User Accepted: 398
 User Tried: 469
 Total Accepted: 399
 Total Submissions: 1004
 Difficulty: Medium
 Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

 However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

 Example:
 Input: [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 since they don't influence the operation priority. So you should return "1000/(100/10/2)".

 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2



 这道题给了我们一个数组，让我们确定除法的顺序，从而得到值最大的运算顺序，并且不能加多余的括号。刚开始博主没看清题，以为是要返回最大的值，就直接写了个递归的暴力搜索的方法，结果发现是要返回带括号的字符串，尝试的修改了一下，觉得挺麻烦。于是直接放弃抵抗，上网参考大神们的解法，结果大吃一惊，这题原来还可以这么解，完全是数学上的知识啊，太tricky了。数组中n个数字，如果不加括号就是：

 x1 / x2 / x3 / ... / xn

 那么我们如何加括号使得其值最大呢，那么就是将x2后面的除数都变成乘数，比如只有三个数字的情况 a / b / c，如果我们在后两个数上加上括号 a / (b / c)，实际上就是a / b * c。而且b永远只能当除数，a也永远只能当被除数。同理，x1只能当被除数，x2只能当除数，但是x3之后的数，只要我们都将其变为乘数，那么得到的值肯定是最大的，所以就只有一种加括号的方式，即:

 x1 / (x2 / x3 / ... / xn)

 这样的话就完全不用递归了，这道题就变成了一个道简单的字符串操作的题目了，这思路，博主服了，参见代码如下：
 */
public class OptimalDivision {

    public String Solution(int[] nums){
        if (nums == null || nums.length == 0) return "";
        String res = Integer.toString(nums[0]);
        if (nums.length == 1) return res;
        if (nums.length == 2) return res + "/" + Integer.toString(nums[1]);
        res += "/(" + Integer.toString(nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            res += "/" + Integer.toString(nums[i]);
        }
        return res + ")";
    }





}
