//解法1，循环加二维数组，二维数组缓存中间结果，数组中坐标为(i,j)的元素表示到达坐标为(i,j)的格子时能拿到的礼物价值总和的最大值
public class Solution{
    public int getMax_Value(int[][] values){
        int rows = values.length;
        int cols = values[0].length;
        if(values == null || rows <= 0 || cols <= 0){
            return 0;
        }
        int[][] maxValue = new int[rows][];
        for(int i = 0; i < rows; i++){
            maxValue[i] = new int[cols];
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int left = 0;
                int up = 0;
                if(j > 0){
                    left = maxValue[i][j - 1];
                }
                if(i > 0){
                    up = maxValue[i - 1][j];
                }
                maxValue[i][j] = max(up, left) + values[i][j];
            }
        }
        return maxValue[rows - 1][cols - 1];
    }
	public int max(int i, int j) {
		return (i < j)?j:i;
	}
	public static void main(String[] args) {
		example47 ex = new example47();
		int[][] values = {{1, 10, 3, 8},{12, 2, 9, 6},{5, 7, 4, 11},{3, 7, 16, 5}};
		System.out.println(ex.getMax_Value(values));
	}
}


//解法二，循环加一维数组，因为最大价值只依赖于（i-1,j）和（i,j-1），因此不需要保存第i-2行及以上的数据，所以建一个数组长度为cols的一维数组，
//数组中保存f(i,0),f(i,1),...,f(i,j-1),f(i-1,j),f(i-1,j+1),f(i-1,j+2),...,f(i-1,cols-1),还不知道为什么呢

public class Solution{
    public int getMax_Value(int[][] values){
            int rows = values.length;
            int cols = values[0].length;
            if(values == null || rows <= 0 || cols <= 0){
                return 0;
            }
            int[] maxValue = new int[cols];

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    int left = 0;
                    int up = 0;
                    if(j > 0){
                        left = maxValue[j - 1];
                    }
                    if(i > 0){
                        up = maxValue[j];
                    }
                    maxValue[j] = max(up, left) + values[i][j];
                }
            }
            return maxValue[cols - 1];
        }
      public int max(int i, int j) {
        return (i < j)?j:i;
      }
      public static void main(String[] args) {
        example47 ex = new example47();
        int[][] values = {{1, 10, 3, 8},{12, 2, 9, 6},{5, 7, 4, 11},{3, 7, 16, 5}};
        System.out.println(ex.getMax_Value(values));
      }
}
