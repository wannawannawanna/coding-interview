package Offer;

public class example3_1_1 {
	public int FindDupWithoutRevisingArray(int[] arr, int length) {
		if(arr == null || length <= 0) {
			return -1;
		}
		int start = 1;
		int end = length - 1;
		while(end >= start) {
			int count = 0;
			if(start == end){
				if(count >1 ) {
					return start;
				}
				else {
					break;
				}
				
			}
			int middle = (end - start)/2 + start ; 
			for(int i = 0; i < length; i++) {
				if(start <= arr[i] && arr[i] <= middle) {
					count += 1;
				}
			}
			if(count > middle - start +1) {
				end = middle;
			}
			else {
				start = middle + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		example3_1_1 ex = new example3_1_1();
		int[] num = {2,3,5,4,3,2,7,6};
		System.out.println(ex.FindDupWithoutRevisingArray(num, 8));
	}
}
