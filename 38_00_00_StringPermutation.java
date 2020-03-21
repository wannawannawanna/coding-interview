import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if(str == null){
            return result;
        }
        int begin = 0;
        char[] chars = str.toCharArray();
        PermutationCore(chars, begin, result);
        Collections.sort(result); //保证输出是有序的
        return result;
    }
    public void PermutationCore(char[] chars, int begin, ArrayList<String> list){
        if(chars==null || chars.length==0 || begin<0 || begin>chars.length-1) { return ; }
        if(begin == chars.length - 1){
            if (!list.contains(String.valueOf(chars))){ //去重
                list.add(String.valueOf(chars));
            }
        }
        else{
            for(int i = begin; i < chars.length; i++){
                swap(chars, i, begin);
                PermutationCore(chars, begin + 1, list);
                swap(chars, i, begin);
            }
        }
    }
//     public void swap(char A, char B){  //不知道为什么这样交换数组元素不可以
//         char temp = A;
//         A = B;
//         B = temp;
//     }
    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
