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
    public void swap(input[] num, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    int partition(int[] nums, int begin, int end){
        if(begin == end){
            return begin;
        }
        int base = begin;//从左到右扫描，使用与链表
        int slow = begin;//标致着替换的位置,slow最终会停留在比base元素小的最后一个元素下标上，[3,6,2,1,4,2,7],这时slow等于下标5。
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
