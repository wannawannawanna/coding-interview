public class Solution {
    public int JumpFloor(int target) {
        int[] result = {0, 1, 2};
        if(target <= 2){
            return result[target];
        }
        int one = 1;//算法思路是斐波那契，但是有一点不同，n=2的时候，跳台阶是2，斐波那契是1。
        int two = 2;
        int sum = 0;
        for(int i = 3; i <= target; i++){
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
