//跟翻转字符串一个意思，可以把整个字符串分为两部分，前n个和后面剩下所有元素的两个字符串，
//先翻转两个小的字符串，然后再翻转整个字符串，如abcdefg,n = 2, 翻转两个小字符串之后bagfedc,再翻转整个字符串之后cdefgab
public class Solution {
    public String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        if(str == null || n >= chars.length){
            return str;   //如果n大于数组长度，说明不翻转，所以返回原字符串
        }
        Reverse(chars, 0, n - 1);
        Reverse(chars, n, chars.length - 1);
        Reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }
    public void Reverse(char[] chars, int start, int end){
        int length = chars.length;
        if(chars == null || length <= 0 || start < 0 || end >= length || start >= end){
            return;
        }
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    } 
}
