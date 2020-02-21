package Offer;

public class example4 {
	public boolean FindFromTwoDimensionalArray(int[][] arr, int col, int row, int number) {
		if(arr == null) {
			return false;
		}
		if(arr != null & col > 0 && row >0) {
			int r = 0;
			int c = col - 1;
			while(r < row && c >= 0) {
				if(arr[r][c] == number) {
					System.out.println("r is " + r);
					System.out.println("c is " + c);
					return true;
					
				}
				else if(arr[r][c] < number) {
					r += 1;
				}
				else {
					c -= 1;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		example4 ex = new example4();
//		int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int[][] arr = {};
		System.out.println(ex.FindFromTwoDimensionalArray(arr, 0, 0, 4));
//		System.out.println(ex.FindFromTwoDimensionalArray(arr, 4, 4, 4));
	}
}
