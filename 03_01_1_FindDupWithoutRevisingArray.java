package Offer;

public class example3_1 {
	public int FindDupWithoutRevisingArray(int[] arr, int length) {
		if(arr == null || length<= 0) {
			return -1;
		}
		int[] arrc = new int[length];
		for(int i = 0; i < length; i++ ) {
			if(arrc[arr[i]] == arr[i]) {
				return arr[i];
			}
			arrc[arr[i]] = arr[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		example3_1 ex31 = new example3_1();
		int[] num = {2,3,5,4,3,2,6,7};
		System.out.println(ex31.FindDupWithoutRevisingArray(num,8));
		System.out.println(num);
	}
}
