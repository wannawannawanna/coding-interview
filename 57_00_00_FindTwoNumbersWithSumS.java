    
// 由于是有序数组, 所以才可以用双索引
// 左右双索引
// 和小了++left, 和大了--right
// 时间复杂度O(N)， 空间复杂度O(N)
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
//对应每个测试案例，输出两个数，小的先输出。
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length <= 0){
            return list;
        }
        int right = array.length - 1;
        int left = 0;
        while(left < right){
            if(array[left] + array[right] == sum){
                list.add(array[left]);  //两个数的和为一定时，两个数越接近他的乘积越大，如1,2,3,4,5,6，和为7，有2,5和3,4，后者的乘积大，
                //所以找到第一个和为s的两个数字之后就可以打印出来了，其实是隐式判断。还有一点，两个数字中小的先输出，所以先添加left，然后添加right
                list.add(array[right]);
                return list;
            }
            else if(array[left] + array[right] > sum){
                right--;
            }
            else{
                left++;
            }
        }
        return list;
    }
}
