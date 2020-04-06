//定义函数f(i)表示从第i位数字开始的不同翻译的数目，那么f(i) = f(i + 1) + g(i, i + 1)*f(i + 2)
//当第i位和第i + 1位两位数字拼接起来的数字在10~25范围内时，函数g(i, i + 1)的值为1，否则为0
public class Solution{
    public int GetTranslationCount(int number){
        if(number < 0){
            return 0;
        }
        String numberInString = Integer.toString(number);
        return GetTranslationCount(numberInString);
    }
    public int GetTranslationCount(String number){
        int length = number.length();
        int[] counts = new int[length];
        int count = 0;
        for(int i = length - 1; i >= 0; i--){
            if(i < length - 1){
                count = counts[i + 1];
            }
            else{
                count = 1;
            }
            if(i < length - 1){
                int digit1 = number.charAt(i) - '0';  //char to int
                int digit2 = number.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if(0 <= converted && converted <= 25){
                    if(i < length - 2){
                        count += counts[i + 2];   // 至少倒数第三位开始才包括f(i+2) 
                    }
                    else{
                        count += 1;  // 倒数第二位至多将最后两位的组合+1
                    }
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }
    public static void main(String[] args) {
    	example45 ex = new example45();
    	System.out.println(ex.GetTranslationCount(12218));
    }
}
