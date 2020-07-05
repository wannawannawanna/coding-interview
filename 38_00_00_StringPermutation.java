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



// 字符串的组合

// 解法一
// 位计算法
// 若字符串长度为n, 则所有组合之和为C(1,n)+C(2,n)+...+C(n,n)=2^(n)-1;
public ArrayList<String> Combination(String str){
    ArrayList<String> result = new ArrayList<String>();
    if(str == null || str.length() == 0){
        return result;
    }
    int length = str.length();
    int n = 1 << length;   // 2^n
    for(int i = 1; i < n; i++){  //2^0不用算,所有状态加起来是2^n-1,所以1到2^n
        String s;
        for(int j = 0; j < length; j++){  //将1到2^n-1用二进制表示，将所有位上的1都找出来
            int temp = i;
            if((i & (1 << j)) != 0){ //如果j位是1，就会被找出来
                s += str.charAt(j);
            }
        }
        result.add(s);
    }
    Collections.sort(result); //保证输出是有序的
    return result;
    
}
