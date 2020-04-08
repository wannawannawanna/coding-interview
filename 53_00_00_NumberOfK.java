//二分查找first value+二分查找last value, 时间复杂度O(logN)
// (一)递归二分查找 
public class NumberOfK {
	public int getFirstK(int[] array, int k, int start, int end){
        if(start > end){
            return -1; //表示没找到k
        }
        int middle = (start + end) / 2;
        int NumOfMiddle = array[middle];
        if(NumOfMiddle == k){
            if((middle > 0 && array[middle - 1] != k) || middle == 0){
                return middle;
            }
            else{
                end = middle - 1;
            }
        }
        else if(NumOfMiddle > k){
            end = middle - 1;
        }
        else{
            start = middle + 1;
        }
        return getFirstK(array, k, start, end);
    }
    public int getLastK(int[] array, int k, int start, int end){
        if(start > end){
            return -1;
        }
        int middle = (start + end) / 2;
        int NumOfMiddle = array[middle];
        if(NumOfMiddle == k){
            if((middle < array.length - 1 && array[middle + 1] != k) || middle == array.length - 1){
                return middle;
            }
            else{
                start = middle + 1;
            }
        }
        else if(NumOfMiddle > k){
            end = middle - 1;
        }
        else{
            start = middle + 1;
        }
        return getLastK(array, k, start, end);
    }
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        if(array != null && array.length > 0){
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);
            if(first > -1 && last > -1){
                number = last - first + 1;
            }
        }
        return number;
    }
    public static void main(String[] args) {
    	example53 ex = new example53();
    	int[] array = {1,2,3,3,3,3,4,5};
    	System.out.println(ex.GetNumberOfK(array, 3));
    }
}

//非递归,while的条件是start <= end
public class Solution {
    public int GetFirstK(int[] array, int k) {
        if (array == null) {
            return -1;
        }
        int length = array.length;
        int start = 0;
        int end = length - 1;
        int middle = (start + end) / 2;
        while (start <= end) {
            if (array[middle] == k) {
                if ((middle > 0 && array[middle - 1] != k) || middle == 0) {
                    return middle;
                }
                else {
                    end = middle - 1;
                }
            }
            else {
                if (array[middle] < k) {
                    start = middle + 1;
                }
                else {
                    end = middle - 1;
                }
            }
            middle = (start + end) / 2;
        }
        return -1;
    }


    public int GetLastK(int[] array, int k) {
        if (array == null) {
            return -1;
        }
        int length = array.length;
        int start = 0;
        int end = length - 1;
        int middle = (start + end) / 2;
        while (start <= end) {
            if (array[middle] == k) {
                if ((middle < length - 1 && array[middle + 1] != k) || middle == length - 1) {
                    return middle;
                }
                else {
                    start = middle + 1;
                }
            }
            else {
                if (array[middle] < k) {
                    start = middle + 1;
                }
                else {
                    end = middle - 1;
                }
            }
            middle = (start + end) / 2;
        }
        return -1;
    }
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        if(array != null && array.length > 0){
            int first = GetFirstK(array, k);
            int last = GetLastK(array, k);
            if(first > -1 && last > -1){
                number = last - first + 1;
            }
        }
        return number;
    }
}
