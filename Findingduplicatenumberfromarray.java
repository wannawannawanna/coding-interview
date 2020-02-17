package Offer;


public class Findingduplicatenumberfromarray {
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
		Findingduplicatenumberfromarray fdna = new Findingduplicatenumberfromarray();
		int[] num = {2,3,1,0,2,5,3};
		System.out.println(num);
		System.out.println(fdna.finddup(num, 7));
	}
}
