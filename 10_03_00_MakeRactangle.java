//跟跳台阶一样
public class Solution {
    public int RectCover(int target) {
        int[] result = {0, 1, 2};
        if(target <= 2){
            return result[target];
        }
        int one = 1;
        int two = 2;
        int sum = 0;
        for(int i = 3; i <= target; i++){  //注意下标，是从3开始的
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
