// 数字的格式可以用A[.[B]][e|EC]表示，其中A和C都是整数，
// (可以有正负号，也可以没有)，而B是一个无符号整数
public class Solution {
    private int index = 0;
    public boolean isNumeric(char[] str) {
        if(str == null){
            return false;
        }
        boolean numeric = scanInteger(str);
        if(index < str.length && str[index] == '.'){
            index++;
            numeric = scanUnsignedInteger(str) || numeric;
            //这里用||是因为小数点前面/后面可以由数字，也可以没有数字，如.123等于0.123或者233.等于233.0
        }
        if(index < str.length && (str[index] == 'E' || str[index] == 'e')){
            index++;
            numeric = numeric && scanInteger(str);
            //这里用&&是因为当e/E前面/后面没有数字时都不能表示数字，如.e1或者12e
        }
        return numeric && index == str.length;  //&& index == str.length;是要看有没有扫描到末尾，如果没有就返回false,说明还有别的符号之类的
    }
    public boolean scanInteger(char[] str){
        if(index < str.length && (str[index] == '+' || str[index] == '-')){
            index++;
        }
        return scanUnsignedInteger(str);
    }
    public boolean scanUnsignedInteger(char[] str){
        int start = index;
        while(index < str.length && (str[index] >= '0' && str[index] <= '9')){
            index++;
        }
        return index > start;
    }
}



//正则表达式解法
public class Solution {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}
/*
以下对正则进行解释:
[\\+\\-]?            -> 正或负符号出现与否
\\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
(\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                        否则一起不出现
([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                        紧接着必须跟着整数；或者整个部分都不出现
*/
