//变态调台阶，青蛙可以一次跳1个台阶，一次可以跳2个台阶，...一次可以跳n个台阶，用数学归纳法得知总共有2^(n-1)种跳法
public class Solution {
    public int JumpFloorII(int target) {
        int a=1; return a<<(target-1);  //可以用位运算，非常简单
    }
}
