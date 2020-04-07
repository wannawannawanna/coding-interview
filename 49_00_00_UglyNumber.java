//把只包含因子2,3,5的数成为丑数（1除外），1是第一个丑数
// 解法一: 直接解法, 遍历每一数字
// 该解法用时几十秒, 牛客网无法正常AC
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while(uglyFound < index){
            number++;
            if(isUgly(number)){
                uglyFound++;
            }
        }
        return number;
    }
    public boolean isUgly(int number){
        while(number % 2 == 0){
            number /= 2;
        }
        while(number % 3 == 0){
            number /= 3;
        }
        while(number % 5 == 0){
            number /= 5;
        }
        return (number == 1)?true:false;
    }
}


//解法2，用一维数组，保存排好序的丑数，使用较小的空间消耗换取了时间效率的提升
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int[] UglyNumbers = new int[index];
        UglyNumbers[0] = 1;
        int nextUgly = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(nextUgly < index){
            int min = Min(UglyNumbers[i2] * 2, UglyNumbers[i3] * 3, UglyNumbers[i5] * 5);
            UglyNumbers[nextUgly] = min;  //下一个丑数
            // positionOf2之前的每个丑数*2都会太小,之后的每个丑数*2都会太大
		        // 下次将会使用++positionOf2位置上的丑数*2进行更新
            while(UglyNumbers[i2] * 2 <= UglyNumbers[nextUgly]){
                i2++;
            }
            while(UglyNumbers[i3] * 3 <= UglyNumbers[nextUgly]){
                i3++;
            }
            while(UglyNumbers[i5] * 5 <= UglyNumbers[nextUgly]){
                i5++;
            }
            nextUgly++;
        }
        int ugly = UglyNumbers[index - 1];
        return ugly;
    }
    public int Min(int number1, int number2, int number3){
        int min = (number1 < number2)? number1: number2;
        min = (min < number3)? min: number3;
        return min;
    }
}
