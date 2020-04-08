//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if(array == null || length < 2){
            return;
        }
        int ExclusiveOr = 0;
        for(int i = 0; i < length; i++){
            ExclusiveOr ^= array[i];
        }
        int IndexFirst1 = FindFirst1(ExclusiveOr);
        int n1 = 0;
        int n2 = 0;
        for(int j = 0; j < length; j++){
            if(IsBit1(array[j], IndexFirst1)){
                n1 ^= array[j]; 
            }
            else{
                n2 ^= array[j];
            }
        }
        num1[0] = n1;
        num2[0] = n2;
    }
    public int FindFirst1(int number){  //找到最右边是1的位
        int index = 0;
        while((number & 1) == 0 && index < 32){  //int最大位32
            number = number >> 1;
            index++;
        }
        return index;
    }
    public boolean IsBit1(int number, int index){  //从右边数起的index位是不是1
        number = number >> index; 
        return (number & 1) == 1;
    }
}



//牛客网解法
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];  //可以直接用num1[0]，系统默认给他初始化成0，所以可以直接异或
            }else{
                num2[0] ^= array[i];
            }
        }
    }
     
    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }
     
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
