//第一反应的解法，哈希表，空间复杂度为o(N)
import java.util.*;
public class Solution{
    public int ModeThanHalfNum_Solution(int[] array){
        if(array == null){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
            }
            else{
                int count = map.get(array[i]);
                map.put(array[i], ++count);
            }
        }
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key = (Integer)entry.getKey();
            Integer count = (Integer)entry.getValue();
            if(count * 2 > array.length){
                return key;
            }
        }
        return 0;
    }
}

//解法一，用时间复杂度为o(N)的partition（快排）来查找中位数


//解法二，时间复杂度o(N)用加一减一来抵消元素，如222234,2跟3抵消，2跟4抵消，就剩两个2，返回2
// 目标数超过数组长度的一半，对数组同时去掉两个不同的数字，到最后剩下的一个数就是该数字。如果剩下两个，那么这两个也是一样的，就是结果
// 即 +1 -1实际上就是在去掉两个不同的数字
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null){
            return 0;
        }
        int result = array[0];
        int times = 1;
        for(int i = 1; i < array.length; i++){
            if(times == 0){ 
                result = array[i];
                times = 1;
                
            }
            else if(result == array[i]){
                times++;
            }
            else{
                times--;
            }
        }
        if(!CheckMoreThanHalf(array, result)){
            result = 0;
        }
        return result;
    }
    public boolean CheckMoreThanHalf(int[] array, int result){
        int times = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == result){
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if(times * 2 <= array.length){
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }
}
