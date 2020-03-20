//解法1，递归fibonacci,时间复杂度是指数级的增长


//解法2，从下到上计算，就不会重复计算了，面试的时候面试官想要这个
public class Solution {
    public int Fibonacci(int n) {
        int[] result = {0, 1};
        if(n < 2){
            return result[n];
        }
        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;
        for(int i = 2; i <= n; i++){
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
}
