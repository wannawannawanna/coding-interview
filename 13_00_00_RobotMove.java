public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows < 1 || cols < 1){
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited); //机器人是从（0,0）位置开始运动，所以row, col=0,0
        return count;  //count返回的是格子数
    }
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0; 
        if(0 <= row && row < rows && 0 <= col && col < cols && !visited[row * cols + col] && getDigitSum(row) + getDigitSum(col) <= threshold){
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +  //从四个方向中找到一个格子，就count+=1， 最开始的1是对应的（0,0）格子）
                movingCountCore(threshold, rows, cols, row, col - 1, visited) 
                movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }
    public int getDigitSum(int number){  //举例getDigitSum(35)=8
        int sum = 0;
        while(number > 0){
            sum += number % 10;  //获取个位数上的字
            number = number / 10; //整除10，相当于每个位上的数字往右挪，可以依次获取每个位上的数字
        }
        return sum;
    }
}
