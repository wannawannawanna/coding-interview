public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || matrix.length==0 || str==null || str.length==0 || matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
            return false ; //考虑所有可能发生的边界值
        }
        boolean[] visited = new boolean[rows * cols];  //标致着当前位置有没有被访问过，赋初值都是false
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        int pathLength = 0;
        for(int row = 0; row < rows; row++){  //可以从矩阵中任意位置开始，只要找到一个路径就可以返回
            for(int col = 0; col < cols; col++){
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited){
        boolean hasPath = false;  //表示是否已经找到路径
        if(0 <= row && row < rows && 0 <= col && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]){
            pathLength++;  //表示找到的字符数
            visited[row * cols + col] = true;
            if(pathLength == str.length){
                return true;   //当str中所有字符都找到，就返回true
            }
            hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)||
                hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited);
            if(!hasPath){   //没找到路径就返回上一层
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }


}
