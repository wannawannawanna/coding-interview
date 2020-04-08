
//数组中只有一个数字出现依次，其他都是三次
//位运算，如果一个数字出现三次，那么他的二进制表示的每一位也出现三次，如果把每一位分别加起来，那么每一位都能被3整除
//因此，可以找出只出现一次的那一个数字，即所有位都加起来，然后余3，这样剩下的就是只出现一次的数字
public class Solution{
    boolean Invalid = false;
	public int FindNumberAppearOnce(int[] array){
		int length = array.length;
		if(array == null || length < 4) {
			Invalid = true;
			return -1;
		}	
		int[] bitSum = new int[32];  //存储二进制表示的每一位的和
		for(int i = 0; i < bitSum.length; i++) {
			bitSum[i] = 0;
		}
		for(int i = 0; i < length; i++) {
			int bitMask = 1;  //实现滤波器的功能，依次选取array中第i个数字的所有位上的值（0/1）
			for(int j = 31; j >= 0; j--) {
				int bit = array[i] & bitMask;
				if(bit != 0) {
					bitSum[j] += 1; // bitSum[31]存储最低位的二进制的和,因为还原只出现一次的数字的时候，
					//最先获取最高位上的数字，然后依次往左移
				}
				bitMask = bitMask << 1;
			}
		}
		int result = 0;
		for(int i = 0; i < 32; i++) {
			result = result << 1;
			result += bitSum[i] % 3;
		}
		return result;
	}
	public static void main(String[] args) {
		example56 ex = new example56();
		int[] array = {-1,2,2,2};
		System.out.println(ex.FindNumberAppearOnce(array));
	}
}
