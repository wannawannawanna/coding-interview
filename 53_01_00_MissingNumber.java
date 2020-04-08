//二分法, 利用下标和元素是否相等
public class Solution {
	public int GetMissingNumber(int[] number) {
		if(number == null) {
			return -1;
		}
		int start = 0;
		int end = number.length - 1;
		
		while(start <= end) {
			int middle = (start + end) / 2;
			if(number[middle] != middle) {  //下标跟数值不相等
				if(middle == 0 || (middle > 0 && number[middle - 1] == middle - 1)) { //如果左边元素跟他的下标相等，那么当前数字就是缺失的哪一个值
					return middle;
				}
				else {
					end = middle - 1; //说明不是第一个不相等的那一个值
				}
			}
			else {
				start = middle + 1;  //前面的所有数值跟下标都相等，往后找不相等的
			}
		}
    // 缺失n-1
		if(start == number.length) {  //所有下标都一样的话，那就返回数组长度，说明缺n
			return number.length;
		}
		return -1;
	}
	public static void main(String[] args) {
		example53_1 ex = new example53_1();
		int[] number = {0,1,2,7,3,5};
		System.out.println(ex.GetMissingNumber(number));
	}
}
