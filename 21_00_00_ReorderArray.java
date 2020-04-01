//剑指offer,能保证奇数在前，偶数在后，但是奇数与奇数，偶数与偶数之间相对位置会被改变
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 1){
            return;
        }
        int first = 0;
        int length = array.length;
        int second = length - 1;
        while(first <= second){
            while(first <= second && (array[first] & 0x1) != 0){
                first++;
            }
            while(first <= second && (array[second] & 0x1) == 0){
                second--;
            }
            if(first <= second){
                int temp = array[first];
                array[first] = array[second];
                array[second] = temp;
                
            }
        }
    }
}

//扩展，面试官满意的代码是把能封装的函数都封装起来，把两处的判断标准封装


//牛客网上还要求交换后奇数与奇数，偶数与偶数的相对位置不变
/**
 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
 * 2.i从左向右遍历，找到第一个偶数。
 * 3.j从i+1开始向后找，直到找到第一个奇数。
 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 * 5.終止條件：j向後遍歷查找失敗。
 */
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int first = 0;
        int length = array.length;
        while(first < length){
            while(first < length && (array[first] & 0x1) != 0){  //直到找到第一个偶数
                first++;
            }
            int second = first + 1;
            while(second < length && (array[second] & 0x1) == 0){  //直到找到第一个奇数
                second++;
            }
            if(second < length){
                int temp = array[second];
                for(int i = second - 1; i >= first; i--){
                    array[i + 1] = array[i];
                }
                array[first] = temp;
                first++;
            }
            else{
                break;
            }
        }
    }
}
