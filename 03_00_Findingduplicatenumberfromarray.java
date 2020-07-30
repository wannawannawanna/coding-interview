package Offer;


public class Findingduplicatenumberfromarray {
	public int finddup(int[] input, int length) {
		if(input==null || length<=0) {
			return -1;
		} 
		for(int i = 0; i < length; i++) {  //相等的话，则接着扫描下一个数字就行			
			while(i != input[i]) {	//如果不相等，m=input[i]			
				if(input[i] == input[input[i]]) {  //则拿m和第m个数字进行比较，如果相等就已经找到了重复的数字						
					return input[i];
				}
				int temp = input[i]; //则拿m和第m个数字进行比较，如果不相等就互换一下
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




public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
			return false;
		} 
        for(int i = 0; i < length; i++){
            if(numbers[i] < 0 || length - 1 < numbers[i]){
                return false;
            }
        }
		for(int i = 0; i < length; i++) {			
			while(i != numbers[i]) {				
				if(numbers[i] == numbers[numbers[i]]) {	
                    duplication[0] = numbers[i];
					return true;
				}
                //swap numbers[i] and numbers[numbers[i]]
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;

			}
		}
		return false;
    }
}
