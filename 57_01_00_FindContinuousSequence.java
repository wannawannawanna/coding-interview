//输入一个正数s,打印出所有和为s的连续正数序列，如输入15， 1+2+3+4+5=4+5+6=7+8=15，所以打印1~5,4~6,7~8
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(sum < 3){
            return result;
        }
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;//增加small到（1+sum）/2为止
        int curSum = small + big;
        while(small < middle){
            if(curSum == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();  //每次创建新的
                for(int i = small; i <= big; i++){
                    list.add(i);
                }
                result.add(list);
            }
            while(curSum > sum && small < middle){  //当curSum > sum的时候只能从左边减去一些元素，因为big是依次增加的，
                                               //然后判断cursum是否等于sum
                curSum -= small;
                small = small + 1;
                if(curSum == sum){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for(int i = small; i <= big; i++){
                        list.add(i);
                    }
                    result.add(list);
                }
            }
            big++;  //不管有没有找到cursum == sum,big都要加1，如果找到了，那么big用于下一个序列，如果没有就是当前序列中的元素
            curSum += big;
            
        }
        return result;
    }
}
