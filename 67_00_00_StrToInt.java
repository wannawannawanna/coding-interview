/*1. 异常输入和0输入的区分，设置一个全局变量
  2. 正负号的处理
  3. 溢出处理*/
  
  public class Solution {
    private int index = 0;  //用一个全局的变量代表数组的下标
    private boolean Invalid = false;  //判断是否是无效输入
    public int StrToInt(String str) {
        if(str == null || str.length() <= 0){
            Invalid = true;  
            return 0;
        }
        int num = 0;  
        char[] array = str.toCharArray();  //字符串转化成数组
        
        if(index < array.length){
            boolean minus = false;  //判断是不是负数
            if(array[index] == '+'){
                index++;
            }
            else if(array[index] == '-'){
                minus = true;
                index++;
            }
            num = StrToIntCore(array, minus);
        }
        return num;
    }
    public int StrToIntCore(char[] array, boolean minus){
        long num = 0;  //因为可能会溢出所以用long型变量，然后对溢出的数据进行特殊处理，然后再强制类型转换
        while(index < array.length){  //循环检查数组中有没有哪个字符是无效的，
            if(array[index] >= '0' && array[index] <= '9'){
                int flag = minus ? -1 : 1;
                num = num * 10 + flag * (array[index] - '0');
                if((!minus && num > Integer.MAX_VALUE) || (minus && num < Integer.MIN_VALUE)){  //MAX_VALUE=0x7fffffff;
                                                                                              //MIN_VALUE=0x80000000;
                    num = 0;
                    Invalid = true;
                    break;
                }
                else{
                    index++;
                }
            }
            else{  //字符不在‘0’-‘9’的范围之内
                num = 0;
                Invalid = true;
                break;
            }
        }
        return (int)num;
    }
    
}
