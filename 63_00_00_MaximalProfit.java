//函数Diff(i)为卖出价位数组中第i个数字可能获得的最大利润，卖出价固定时买入价越低，利润越高，当扫描到i的时候只需记住前i-1个数字中的最小值，就可最大利润
public class Solution{
    public int MaximalProfit(int[] numbers){
        if(numbers == null || numbers.length < 2){
            return 0;
        }
        int min = numbers[0];
        int MaxDiff = numbers[1] - min;
        for(int i = 2; i < numbers.length; i++){
            if(numbers[i - 1] < min){
                min = numbers[i - 1];
            }
            int currDiff = numbers[i] - min;
            if(currDiff > MaxDiff){
                MaxDiff = currDiff;
            }            
        }
        return MaxDiff;
    }
}

//只需扫描一次，时间复杂度是o(n)


//如果用暴力法时间复杂度o(n^2),找出数组中所有数字，并逐一求出他们的差值，双重for循环
