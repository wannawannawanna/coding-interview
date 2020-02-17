package Offer;


public class example3 {
	public int finddup(int[] input, int length) {
		if(input==null || length<=0) {
			return -1;
		} 
		for(int i = 0; i < length; i++) {			
			while(i != input[i]) {				
				if(input[i] == input[input[i]]) {						
					return input[i];
				}
				int temp = input[i];
				input[i] = input[temp];
				input[temp] = temp;

			}
		}
		return -1;
	}
	public static void main(String[] args) {
		example3 ex3 = new example3();
		int[] num = {2,3,1,0,2,5,3};
		System.out.println(num);
		System.out.println(ex3.finddup(num, 7));
	}
}
