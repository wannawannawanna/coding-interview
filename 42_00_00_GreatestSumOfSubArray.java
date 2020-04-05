//剑指offer
public class Solution {
    boolean InvalidInput = false;
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null){
            InvalidInput = true;
            return 0;
        }
        InvalidInput = false;
        int curSum = 0;
        int GreatestSum = 0x80000000; //负数最小值
        for(int i = 0; i < array.length; i++){
            if(curSum <= 0){
                curSum = array[i];
            }
            else{
                curSum += array[i];
            }
            if(GreatestSum < curSum){
                GreatestSum = curSum;
            }
        }
        return GreatestSum;
        
    }
}



// 牛客网解法
// 将最大的子数组和初始化为array[0]

int FindGreatestSumOfSubArray(int[] array) {
	if (array == null) {
		return 0;
	}
	int nCurSum = array[0];
	int nGreatestSum = array[0];
	for (int i = 1; i < array.length; ++i) {
		if (nCurSum <= 0) {
			nCurSum = array[i];
		}
		else {
			nCurSum += array[i];
		}
		if (nCurSum > nGreatestSum) {
			nGreatestSum = nCurSum;
		}
	}

	return nGreatestSum;

}
