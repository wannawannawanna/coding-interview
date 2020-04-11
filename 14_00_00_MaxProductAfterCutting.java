//动态规划，函数f(n)是把长度为n的绳子剪成若干段后各段长度乘积的最大值
//时间复杂度o(n^2),空间复杂度o(n)
public class Solution {
    public int cutRope(int target) {
        if(target < 2){
            return 0; //小于2不能裁剪
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int[] products = new int[target + 1];//为了保持下标和i相等
        products[0] = 0;  
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;  //到这儿是为了自下而上计算f(4),f(5)...等等进行初始化
        int max = 0;
        for(int i = 4; i <= target; i++){  //第一刀的时候有1,2,3，...,n-1个可能
            max = 0;   //给每一个第一刀进行清0
            for(int j = 1; j <= i / 2; j++){ //左右两边乘积是一样的，所以看到刚好切一半就行
                int product = products[j] * products[i - j];
                if(max < product){
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[target];
    }
}



//贪婪算法，时间和空间复杂度都是o(1),当n>=5的时候尽可能多剪出3，当剩下的绳子长度为4时，剪成2个长度为2的绳子就行
//证明：3(n-3) >= 2(n-2),n>=5
public class Solution {
    public int cutRope(int target) {
        if(target < 2){
            return 0; //小于2不能裁剪
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int timesOf3 = target / 3;  //每个数除3余数是1或者2
        if(target == timesOf3 * 3 + 1){  //余数是1的情况
            timesOf3 -= 1;  //剩下4
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;  
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}
