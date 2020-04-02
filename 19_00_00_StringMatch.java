// 当模式中的第二个字符不是“*”时：
// 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
// 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

// 而当模式中的第二个字符是“*”时：
// 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
// 1、模式后移2字符，相当于x*被忽略；
// 2、字符串后移1字符，模式后移2字符；
// 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；

public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }
    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex){
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }
        //时刻判断数组是否越界
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if( (strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length) ){
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||  //匹配一次
                    matchCore(str, strIndex + 1, pattern, patternIndex) ||  //匹配多次，所以patternIndex不变
                    matchCore(str, strIndex, pattern, patternIndex + 2);//能匹配上，但是不想匹配   
            }
            else{
                return matchCore(str, strIndex, pattern, patternIndex + 2);//匹配不上
            }
        }
        if( (strIndex != str.length && str[strIndex] == pattern[patternIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length) ){
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
