//解法一, 用partition排序，与寻找中位数方法一样，寻找k-1位数,然后k-1位数之前的都是比其小的数字
// 时间复杂度O(N), 空间复杂度O(1)
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (input == null || k <= 0 || k > length) {
            return result;
        }
        int start = 0;
        int end = length - 1;
        int index = partition(input, start, end);
        while(index != k - 1) {
            if(index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            }
            else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        
        return result;
        
    }
    public void swap(input[] num, int i, int j){  //切记，参数用数组和下标，
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    int partition(int[] nums, int begin, int end){
        if(begin == end){
            return begin;
        }
        int base = begin;//从左到右扫描，使用与链表
        int slow = begin;//标致着替换的位置,slow最终会停留在比base元素小的最后一个元素下标上，[3,6,2,1,4,2,7],这时slow等于下标3。
        int fast = slow + 1; //fast依次往右扫描，对比是否比base小
        while(fast <= end){
            if(nums[fast] < nums[base]){
                slow++;
                swap(nums[slow], nums[fast]);
            }
            fast++;
        }
        swap(nums[base], nums[slow]);
        return slow;
    }
}


//解法2，先构建一个k大小的数组（容器），将input的前k个元素直接放进去，然后再将数组构造成最大堆，这时将input中前k后面的数组放进去时要判断是否比堆顶
//元素小，如果小放进去，重新调整大顶堆，如果比堆顶大不放进去，直到input中所有数据都被对比完
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (input == null || k <= 0 || k > length) {
            return result;
        }
        int[] array = new int[k];
        for(int i = 0; i < k; i++){
            array[i] = input[i];
        }
        for(int i = k/2 - 1; i >= 0; i--){ //k/2-1是第一个非叶子结点
            adjustHeap(array, i, k);//将数组构造成最大堆形式
        }
        for(int i = k; i < length; i++){
            if(input[i] < array[0]){
                array[0] = input[i];
                adjustHeap(array, 0, k); //重新调整大顶堆
            }
        }
        for(int i : array){
            result.add(i);
        }
        return result;
    }
    //堆排序
    public void adjustHeap(int[] number, int begin, int length){
        int temp = number[begin];
        for(int k = 2 * begin + 1; k < length; k = 2 * k + 1){
            if(k + 1 < length && number[k] < number[k + 1]){
                k++;
            }
            if(temp < number[k]){
                number[begin] = number[k];
                begin = k;
            }else{
                break;
            }
        }
        number[begin] = temp;
    }
}
