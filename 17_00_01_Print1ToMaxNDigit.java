//解法1，没看懂
//解法2，数字的全排列，每个位置都是0~9
public void Print1ToMaxNDigit(int n){
    if(n <= 0){
        return;
    }
    char[] number = new char[n];
    for(int i = 0; i < n; i++){
        number[i] = '0';
    }
    for(int i = 0; i < 10; i++){
        number[0] = i + '0';//加‘0’使int转换成char，第一个位置0~9
        Print1ToMaxNDigitRecursively(number, n, 0);
    }
}

void Print1ToMaxNDigitRecursively(char[] number, int length, int index){
    if(index == length - 1){
        PrintNumber(number);
        return;
    }
    for(int i = 0; i < 10; i++){
        number[index + 1] = i + '0';  //第二个位置，然后开始递归
        Print1ToMaxNDigitRecursively(number, length, index + 1);  
    }
}

//不打印前面的0，如023要打印成23
void PrintNumber(char[] number){
    boolean isBeginning = true;
    for(int i = 0; i < number.length; i++){
        if(isBeginning && number[i] != '0'){
            isBeginning = false;
        }
        if(!isBegining){
            System.out.println(number[i]);
        }
    }
}
