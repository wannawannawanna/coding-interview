//书上的解法不太好，用牛客上的，用四个label（up,down,left,right）判断是否越界，没有越界继续打印

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null){
            return result;
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        int up = 0;
        int down = rows - 1;
        int left = 0;
        int right = colums - 1;
        while(true){
            //最上面一行
            for(int i = left; i <= right; i++){
                result.add(matrix[up][i]);
            }
            //向下
            up++;
            //判断是否越界
            if(up > down){
                break;
            }
            //最右面一列
            for(int i = up; i <= down; i++){
                result.add(matrix[i][right]);
            }
            //向左
            right--;
            if(right < left){
                break;
            }
            //最下面一行
            for(int i = right; i >= left; i--){
                result.add(matrix[down][i]);
            }
            //向上
            down--;
            if(down < up){
                break;
            }
            //最左面一列
            for(int i = down; i >= up; i--){
                result.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }
        return result;
    }
}
