//只有一位的数字0~9，十个
//有两位的数字10~99,九十个
//有三位的数字100~999，九百个。。。。

public class Solution{
    public int digitAtIndex(int index){
		if(index < 0) {
			return -1;
		}
		int digit = 1;
		while(true) {
			int numbers = countOfIntegers(digit);
			if(index < numbers) {
				return digitAtIndex(index, digit);
			}
			index -= digit * numbers;
			digit++;
		}
		//return -1;
	}
  // 获得digits位的数字共有多少个
	public int countOfIntegers(int digit) {
		if(digit == 1) {
			return 10;
		}
		int number = (int)Math.pow(10, digit - 1);
		return number * 9;
	}
  // 获取digits位数的第index个数字
	public int digitAtIndex(int index, int digit) {
		int number = beginNumber(digit) + index / digit;
		int indexFromRight = digit - index % digit;
		for(int i = 1; i < indexFromRight; i++) {  //因为这道题本身是从0开始计数的，所以要加1位，所以从i=1开始
			number /= 10; // number/10将位数降低
		}
		return number % 10;
	}
  // 获得digits位的第一个数字
	public int beginNumber(int digit) {
		if(digit == 1) {
			return 0;
		}
		return (int)Math.pow(10, digit - 1);
	}
	public static void main(String[] args) {
		example44 ex = new example44();
		System.out.println(ex.digitAtIndex(1001));
	}
}
