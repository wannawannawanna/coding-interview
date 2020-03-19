import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left; //初始化成left，是旋转数组本身是有序的情况，即旋转了0个元素，所以返回第一个元素
        while(array[left] >= array[right]){
            if(right - left == 1){  //二分查找，用双索引，终止条件是两个索引相邻
                return array[right];
            }
            mid = (left + right) / 2;
            if(array[mid] == array[left] && array[left] == array[right]){ //特殊情况{11101}这种数组，无法判断属于左/右哪一个数组里，所以顺序扫描
                int result = array[0];
                for(int i = 0; i < array.length; i++){
                    if(array[i] < result){
                        result = array[i];
                    }
                }
                return result;
            }
            if(array[mid] >= array[left]){
                left = mid;
            }
            else if(array[mid] <= array[right]){
                right = mid;
            }
            
        }
        return array[mid];//返回第一个元素
    }
}
