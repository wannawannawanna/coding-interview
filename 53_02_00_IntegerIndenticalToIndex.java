//数组是单调递增的，所以用二分法查找数值和相等的元素，并返回其下标就可以
public class example53_2 {
	public int IntegerIdenticalToIndex(int[] array) {
		if(array == null) {
			return -1;
		}
		int length = array.length;
		int start = 0;
		int end = length - 1;
		while(start <= end) {
			int middle = (start + end) / 2;
			if(middle == array[middle]) {
				return middle;
			}
			else if(middle < array[middle]) {
				end = middle - 1;
			}
			else {
				start = middle + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		example53_2 ex = new example53_2();
		int[] array = {-3,-1,1,2,4};
		//int[] array = {-3,-1,1,3,5};
		System.out.println(ex.IntegerIdenticalToIndex(array));
	}
}
