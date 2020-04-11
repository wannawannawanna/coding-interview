import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length <= 0){
            return false;
        }
        Arrays.sort(numbers);   //对数组进行排序，因为总共就0~13个数字，所以不管用什么排序其实影响不大
        int numberOfZero = 0;
        int numberOfGap = 0;
        int length = numbers.length;
        for(int i = 0; i < length && numbers[i] == 0; i++){
            numberOfZero++;   //统计0的个数
        }
        int small = numberOfZero;   //因为已经排序了，所以从numberOfZero开始查看是不是顺子
        int big = small + 1;
        while(big < length){   //
            if(numbers[small] == numbers[big]){   //如果有对子，那就不可能是顺子
                return false;
            }
            numberOfGap +=  numbers[big] - numbers[small] - 1;   //查看数组中前后数组之间的间隔，如果是顺子，那么没有间隔，所以减1
            small = big;
            big++;
        }
        return (numberOfZero < numberOfGap)?false:true;  //0的个数比间隔数小的话，选取的牌可以是顺子
    }
}
