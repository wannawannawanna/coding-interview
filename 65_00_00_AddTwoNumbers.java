//不能使用加减乘除，做加法
//分三步走，第一步，各位相加，但不考虑进位，相当于位运算中的异或
//第二步，算进位，只有1+1的时候才能产生进位，相当于位与运算
//第三步，把第一和第二步的结果相加
public class Solution {
    public int Add(int num1,int num2) {
        int sum,carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        while(num2 != 0);  //while的条件刚好使得sum+carry执行一次
        return num1;
    }
}
