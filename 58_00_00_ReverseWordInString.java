public class Solution {
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        Reverse(chars, 0, chars.length - 1);  //翻转整个字符串
        //再翻转每个单词
        int blank = -1;  
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                Reverse(chars, blank + 1, nextBlank - 1);//第一个空格加1是一个单词的开始，第二个空格减1是一个单词的结尾
                blank = nextBlank; //从左开始依次找空格
            }
        }
        Reverse(chars, blank + 1, chars.length - 1);//最后一个单词要单独翻转
        return new String(chars);
    }
  //用双指针形式，夹逼翻转
    public void Reverse(char[] chars, int start, int end){
        int length = chars.length;
        if(chars == null || length <= 0 || start < 0 || end >= length){
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
